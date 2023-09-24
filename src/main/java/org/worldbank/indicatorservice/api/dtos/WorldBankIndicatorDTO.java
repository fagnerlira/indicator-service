package org.worldbank.indicatorservice.api.dtos;

import java.util.List;

public class WorldBankIndicatorDTO {

  private PaginatorDTO pagination;
  private List<CountryIndicatorDTO> countryIndicator;

  public WorldBankIndicatorDTO() {
  }

  public WorldBankIndicatorDTO(final PaginatorDTO pagination,
      final List<CountryIndicatorDTO> countryIndicator) {
    this.pagination = pagination;
    this.countryIndicator = countryIndicator;
  }

  public PaginatorDTO getPagination() {
    return pagination;
  }

  public void setPagination(final PaginatorDTO pagination) {
    this.pagination = pagination;
  }

  public List<CountryIndicatorDTO> getCountryIndicator() {
    return countryIndicator;
  }

  public void setCountryIndicator(
      final List<CountryIndicatorDTO> countryIndicator) {
    this.countryIndicator = countryIndicator;
  }
}
