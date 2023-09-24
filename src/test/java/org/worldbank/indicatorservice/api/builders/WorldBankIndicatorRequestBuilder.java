package org.worldbank.indicatorservice.api.builders;

import java.util.List;
import org.worldbank.indicatorservice.api.vo.request.CountryIndicatorRequest;
import org.worldbank.indicatorservice.api.vo.request.PaginationRequest;
import org.worldbank.indicatorservice.api.vo.request.WorldBankIndicatorRequest;

public class WorldBankIndicatorRequestBuilder {

  private final WorldBankIndicatorRequest request = new WorldBankIndicatorRequest();

  public WorldBankIndicatorRequestBuilder() {
  }

  public static WorldBankIndicatorRequestBuilder builder() {
    return new WorldBankIndicatorRequestBuilder();
  }

  public WorldBankIndicatorRequest build() {
    return request;
  }

  public WorldBankIndicatorRequestBuilder withPagination(final PaginationRequest pagination) {
    request.setPagination(pagination);
    return this;
  }

  public WorldBankIndicatorRequestBuilder withCountryIndicator(
      final List<CountryIndicatorRequest> countryIndicator) {
    request.setCountryIndicator(countryIndicator);
    return this;
  }
}
