package org.worldbank.indicatorservice.api.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorldBankIndicatorResponse {

  private PaginationResponse pagination;
  private List<CountryIndicatorResponse> countryIndicator;

  public WorldBankIndicatorResponse() {
  }

  public WorldBankIndicatorResponse(final PaginationResponse pagination,
      final List<CountryIndicatorResponse> countryIndicator) {
    this.pagination = pagination;
    this.countryIndicator = countryIndicator;
  }

  public PaginationResponse getPagination() {
    return pagination;
  }

  public void setPagination(final PaginationResponse pagination) {
    this.pagination = pagination;
  }

  public List<CountryIndicatorResponse> getCountryIndicator() {
    return countryIndicator;
  }

  public void setCountryIndicator(
      final List<CountryIndicatorResponse> countryIndicator) {
    this.countryIndicator = countryIndicator;
  }
}
