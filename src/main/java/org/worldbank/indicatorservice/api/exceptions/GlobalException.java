package org.worldbank.indicatorservice.api.exceptions;

public class GlobalException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final IssueParent issue;

  protected GlobalException(final IssueParent issue) {
    this.issue = issue;
  }

  public IssueParent getIssue() {
    return issue;
  }
}
