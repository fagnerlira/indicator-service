package org.worldbank.indicatorservice.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.worldbank.indicatorservice.api.contantes.ApiConstants;
import org.worldbank.indicatorservice.api.mappers.WorldBankIndicatorResponseMapper;
import org.worldbank.indicatorservice.api.usecase.IndicatorUseCase;
import org.worldbank.indicatorservice.api.vo.response.WorldBankIndicatorResponse;

@RestController
@RequestMapping("/indicators")
public class IndicatorController {

  private final IndicatorUseCase indicatorUseCase;
  private final WorldBankIndicatorResponseMapper mapper;

  public IndicatorController(final IndicatorUseCase indicatorUseCase,
      final WorldBankIndicatorResponseMapper mapper) {
    this.indicatorUseCase = indicatorUseCase;
    this.mapper = mapper;
  }


  @Operation(summary = "Get a indicators by its country code")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found the Indicators",
          content = {@Content(mediaType = "application/json",
              schema = @Schema(implementation = WorldBankIndicatorResponse.class))}),
      @ApiResponse(responseCode = "404", description = "Country Code not found",
          content = @Content)})
  @GetMapping
  public ResponseEntity<WorldBankIndicatorResponse> indicators(
      @Parameter(
          description = ApiConstants.COUNTRY_CODE_VALUE,
          required = false,
          name = ApiConstants.COUNTRY_CODE_NAME
      )
      @RequestParam String countryCode) {
    final var dto = indicatorUseCase.execute(countryCode);
    final var response = mapper.worldBankIndicatorDTOToResponse(dto);
    return ResponseEntity.ok(response);
  }
}
