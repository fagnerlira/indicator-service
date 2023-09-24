package org.worldbank.indicatorservice.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.worldbank.indicatorservice.api.dtos.WorldBankIndicatorDTO;
import org.worldbank.indicatorservice.api.vo.request.WorldBankIndicatorRequest;
import org.worldbank.indicatorservice.api.vo.response.WorldBankIndicatorResponse;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WorldBankIndicatorResponseMapper {

  WorldBankIndicatorResponse worldBankIndicatorDTOToResponse(
      final WorldBankIndicatorDTO dto);

  WorldBankIndicatorDTO worldBankIndicatorRequestToDTO(
      final WorldBankIndicatorRequest request
  );
}
