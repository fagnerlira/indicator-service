package org.worldbank.indicatorservice.api.exceptions;

public abstract class IssueParent {

  private int code;
  private String message;

  protected IssueParent() {
  }

  protected IssueParent(final IssueEnum issue) {
    code = issue.getCode();
    message = issue.getFormattedMessage();
  }

  protected IssueParent(final IssueEnum issue, final Object... args) {
    code = issue.getCode();
    message = issue.getFormattedMessage(args);
  }

  public int getCode() {
    return code;
  }

  public void setCode(final int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }
}
