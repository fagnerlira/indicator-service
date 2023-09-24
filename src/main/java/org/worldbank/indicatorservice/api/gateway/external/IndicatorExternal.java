package org.worldbank.indicatorservice.api.gateway.external;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.util.UriComponentsBuilder;
import org.worldbank.indicatorservice.api.exceptions.ExternalServiceException;
import org.worldbank.indicatorservice.api.exceptions.IssueEnum;
import org.worldbank.indicatorservice.api.gateway.client.HttpClient;
import org.worldbank.indicatorservice.api.properties.WorldBankUrlProperties;
import org.worldbank.indicatorservice.api.vo.request.WorldBankIndicatorRequest;

@Component
public class IndicatorExternal {

  private final HttpClient client;
  private final WorldBankUrlProperties properties;

  public IndicatorExternal(final HttpClient client, final WorldBankUrlProperties properties) {
    this.client = client;
    this.properties = properties;
  }

  public WorldBankIndicatorRequest getIndicators(String countryCode) {
    try {
      final String url = getUrl(countryCode);
      return client.get(url, WorldBankIndicatorRequest.class);
    } catch (HttpClientErrorException | ResourceAccessException e) {
      throw ExternalServiceException.errorCallingExternalService(
          IssueEnum.EXTERNAL_SERVICE_ERROR, countryCode);
    }
  }

  private String getUrl(final String countryCode) {
    return UriComponentsBuilder.newInstance()
        .scheme(properties.getScheme())
        .host(properties.getHost())
        .path(properties.getPath())
        .buildAndExpand(countryCode, properties.getEndPath())
        .toUriString();
  }
}
