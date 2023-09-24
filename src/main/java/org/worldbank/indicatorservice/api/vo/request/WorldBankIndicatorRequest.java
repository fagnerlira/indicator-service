package org.worldbank.indicatorservice.api.vo.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import org.worldbank.indicatorservice.api.deserializer.WorldBankIndicatorRequestDeserializer;

@JsonDeserialize(using = WorldBankIndicatorRequestDeserializer.class)
public class WorldBankIndicatorRequest {

  private PaginationRequest pagination;
  private List<CountryIndicatorRequest> countryIndicator;

  public WorldBankIndicatorRequest() {
  }

  public WorldBankIndicatorRequest(final PaginationRequest pagination,
      final List<CountryIndicatorRequest> countryIndicator) {
    this.pagination = pagination;
    this.countryIndicator = countryIndicator;
  }

  public PaginationRequest getPagination() {
    return pagination;
  }

  public void setPagination(final PaginationRequest pagination) {
    this.pagination = pagination;
  }

  public List<CountryIndicatorRequest> getCountryIndicator() {
    return countryIndicator;
  }

  public void setCountryIndicator(
      final List<CountryIndicatorRequest> countryIndicator) {
    this.countryIndicator = countryIndicator;
  }
}
