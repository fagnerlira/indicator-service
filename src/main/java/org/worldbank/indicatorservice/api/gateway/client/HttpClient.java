package org.worldbank.indicatorservice.api.gateway.client;

public interface HttpClient {

  <T> T get(final String url, final Class<T> expectedResponseType);
}
