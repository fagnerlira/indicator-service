package org.worldbank.indicatorservice.api.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class IssueDescription {

  private int status;
  private String reason;
  private String body;

  public int getStatus() {
    return status;
  }

  public void setStatus(final int status) {
    this.status = status;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(final String reason) {
    this.reason = reason;
  }

  public String getBody() {
    return body;
  }

  public void setBody(final String body) {
    this.body = body;
  }

  @Override
  public String toString() {
    return "{" + "status=" + status + ", reason='" + reason + '\'' + ", body=" + body + '}';
  }
}
