package org.worldbank.indicatorservice.api.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginationResponse {

  private Integer page;
  private Integer pages;
  private Integer perPage;
  private Integer total;
  private String sourceId;
  private Date lastUpdated;

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
