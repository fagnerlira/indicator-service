package org.worldbank.indicatorservice.api.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "world-bank-url")
public class WorldBankUrlProperties {

  private String scheme;
  private String host;
  private String path;
  private String endPath;

  public String getScheme() {
    return scheme;
  }

  public void setScheme(final String scheme) {
    this.scheme = scheme;
  }

  public String getHost() {
    return host;
  }

  public void setHost(final String host) {
    this.host = host;
  }

  public String getPath() {
    return path;
  }

  public void setPath(final String path) {
    this.path = path;
  }

  public String getEndPath() {
    return endPath;
  }

  public void setEndPath(final String endPath) {
    this.endPath = endPath;
  }
}
