package org.worldbank.indicatorservice.api.gateway.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClientImpl implements HttpClient {

  private static Logger LOGGER = LoggerFactory.getLogger(HttpClientImpl.class);

  private final RestTemplate restTemplate;


  public HttpClientImpl(final RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public <T> T get(final String url, final Class<T> expectedResponseType) {
    return exchange(url, expectedResponseType, null, HttpMethod.GET);
  }

  private <T> T exchange(
      final String url,
      final Class<T> expectedResponseType,
      final HttpEntity<Object> httpEntity,
      final HttpMethod method) {

    LOGGER.debug("Doing a {} on url {}", method, url);
    return restTemplate.exchange(url, method, httpEntity, expectedResponseType).getBody();
  }
}
