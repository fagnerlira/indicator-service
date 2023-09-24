package org.worldbank.indicatorservice.api.vo.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaginationRequest implements Serializable {

  private Integer page;
  private Integer pages;
  @JsonProperty("per_page")
  private Integer perPage;
  private Integer total;
  @JsonProperty("sourceid")
  private String sourceId;
  @JsonProperty("lastupdated")
  private Date lastUpdated;

  public PaginationRequest() {
  }

  public PaginationRequest(final Integer page, final Integer pages, final Integer perPage,
      final Integer total,
      final String sourceId, final Date lastUpdated) {
    this.page = page;
    this.pages = pages;
    this.perPage = perPage;
    this.total = total;
    this.sourceId = sourceId;
    this.lastUpdated = lastUpdated;
  }

  public Integer getPage() {
    return page;
  }

  public void setPage(final Integer page) {
    this.page = page;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(final Integer pages) {
    this.pages = pages;
  }

  public Integer getPerPage() {
    return perPage;
  }

  public void setPerPage(final Integer perPage) {
    this.perPage = perPage;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(final Integer total) {
    this.total = total;
  }

  public String getSourceId() {
    return sourceId;
  }

  public void setSourceId(final String sourceId) {
    this.sourceId = sourceId;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(final Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }
}
