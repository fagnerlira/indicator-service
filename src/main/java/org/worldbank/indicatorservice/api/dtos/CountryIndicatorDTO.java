package org.worldbank.indicatorservice.api.dtos;

public class CountryIndicatorDTO {

  private IndicatorDTO indicator;
  private CountryDTO country;
  private String countryCode;
  private String date;
  private String value;
  private String unit;
  private String obsStatus;
  private Integer decimal;

  public IndicatorDTO getIndicator() {
    return indicator;
  }

  public void setIndicator(final IndicatorDTO indicator) {
    this.indicator = indicator;
  }

  public CountryDTO getCountry() {
    return country;
  }

  public void setCountry(final CountryDTO country) {
    this.country = country;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(final String countryCode) {
    this.countryCode = countryCode;
  }

  public String getDate() {
    return date;
  }

  public void setDate(final String date) {
    this.date = date;
  }

  public String getValue() {
    return value;
  }

  public void setValue(final String value) {
    this.value = value;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(final String unit) {
    this.unit = unit;
  }

  public String getObsStatus() {
    return obsStatus;
  }

  public void setObsStatus(final String obsStatus) {
    this.obsStatus = obsStatus;
  }

  public Integer getDecimal() {
    return decimal;
  }

  public void setDecimal(final Integer decimal) {
    this.decimal = decimal;
  }
}
