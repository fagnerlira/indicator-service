package org.worldbank.indicatorservice.api.usecase;

import static org.mockito.Mockito.when;
import static org.worldbank.indicatorservice.api.constants.ApiConstants.COUNTRY_CODE_VALUE;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.worldbank.indicatorservice.api.builders.WorldBankIndicatorRequestBuilder;
import org.worldbank.indicatorservice.api.dtos.WorldBankIndicatorDTO;
import org.worldbank.indicatorservice.api.gateway.external.IndicatorExternal;
import org.worldbank.indicatorservice.api.gateway.model.Country;
import org.worldbank.indicatorservice.api.gateway.model.Indicator;
import org.worldbank.indicatorservice.api.mappers.WorldBankIndicatorResponseMapper;
import org.worldbank.indicatorservice.api.vo.request.CountryIndicatorRequest;
import org.worldbank.indicatorservice.api.vo.request.PaginationRequest;

@ExtendWith(MockitoExtension.class)
class IndicatorUseCaseTest {

  private IndicatorUseCase indicatorUseCase;
  @Mock
  private IndicatorExternal indicatorExternal;

  @BeforeEach
  void setup() {
    final var mapper = Mappers.getMapper(
        WorldBankIndicatorResponseMapper.class);
    indicatorUseCase = new IndicatorUseCase(indicatorExternal, mapper);
  }

  @Test
  void itShouldReturnWorldBankDTOWithSuccessfully() {
    final var request =
        WorldBankIndicatorRequestBuilder.builder()
            .withPagination(getPagination())
            .withCountryIndicator(List.of(getCountryIndicator()))
            .build();

    when(indicatorExternal.getIndicators(COUNTRY_CODE_VALUE)).thenReturn(request);
    final WorldBankIndicatorDTO result = indicatorUseCase.execute(COUNTRY_CODE_VALUE);

    Assertions.assertNotNull(result);
    Assertions.assertEquals(63, result.getPagination().getTotal());
    Assertions.assertEquals(COUNTRY_CODE_VALUE,
        result.getCountryIndicator().get(0).getCountryCode());
  }

  private static PaginationRequest getPagination() {
    final PaginationRequest pagination = new PaginationRequest();
    pagination.setPage(1);
    pagination.setPages(2);
    pagination.setPerPage(50);
    pagination.setSourceId("2");
    pagination.setTotal(63);
    pagination.setLastUpdated(new Date());
    return pagination;
  }

  private static CountryIndicatorRequest getCountryIndicator() {
    final Indicator indicator = getIndicator();
    final Country country = getCountry();

    final CountryIndicatorRequest countryIndicator = new CountryIndicatorRequest();
    countryIndicator.setIndicator(indicator);
    countryIndicator.setCountry(country);
    countryIndicator.setCountryCode("BRA");
    countryIndicator.setDate("2022");
    countryIndicator.setValue(null);
    countryIndicator.setUnit("");
    countryIndicator.setObsStatus("");
    countryIndicator.setDecimal(1);
    return countryIndicator;
  }

  private static Country getCountry() {
    final Country country = new Country();
    country.setId("BR");
    country.setValue("Brazil");
    return country;
  }

  private static Indicator getIndicator() {
    final Indicator indicator = new Indicator();
    indicator.setId("SI.POV.DDAY");
    indicator.setValue("Poverty headcount ratio at $2.15 a day (2017 PPP) (% of population)");
    return indicator;
  }
}