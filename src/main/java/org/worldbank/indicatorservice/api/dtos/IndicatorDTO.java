package org.worldbank.indicatorservice.api.dtos;

public class IndicatorDTO {

  private String id;
  private String value;

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(final String value) {
    this.value = value;
  }
}
