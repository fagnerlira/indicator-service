package org.worldbank.indicatorservice.api.vo.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import org.worldbank.indicatorservice.api.gateway.model.Country;
import org.worldbank.indicatorservice.api.gateway.model.Indicator;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryIndicatorRequest implements Serializable {

  private Indicator indicator;
  private Country country;
  @JsonProperty("countryiso3code")
  private String countryCode;
  private String date;
  private String value;
  private String unit;
  @JsonProperty("obs_status")
  private String obsStatus;
  private Integer decimal;

  public Indicator getIndicator() {
    return indicator;
  }

  public void setIndicator(final Indicator indicator) {
    this.indicator = indicator;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(final Country country) {
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
