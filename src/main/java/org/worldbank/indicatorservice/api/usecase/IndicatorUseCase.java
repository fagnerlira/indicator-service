package org.worldbank.indicatorservice.api.usecase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.worldbank.indicatorservice.api.dtos.WorldBankIndicatorDTO;
import org.worldbank.indicatorservice.api.gateway.external.IndicatorExternal;
import org.worldbank.indicatorservice.api.mappers.WorldBankIndicatorResponseMapper;
import org.worldbank.indicatorservice.api.vo.request.WorldBankIndicatorRequest;

@Service
public class IndicatorUseCase {

  private static final Logger LOGGER = LoggerFactory.getLogger(IndicatorUseCase.class);
  private final IndicatorExternal indicatorExternal;
  private final WorldBankIndicatorResponseMapper mapper;

  public IndicatorUseCase(final IndicatorExternal indicatorExternal,
      final WorldBankIndicatorResponseMapper mapper) {
    this.indicatorExternal = indicatorExternal;
    this.mapper = mapper;
  }


  public WorldBankIndicatorDTO execute(String countryCode) {
    LOGGER.info("Search indicator by country code: {}", countryCode);
    final WorldBankIndicatorRequest request = indicatorExternal.getIndicators(countryCode);
    return mapper.worldBankIndicatorRequestToDTO(request);
  }
}
