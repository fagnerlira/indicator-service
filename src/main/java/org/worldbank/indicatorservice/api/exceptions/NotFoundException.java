package org.worldbank.indicatorservice.api.exceptions;

public class NotFoundException extends GlobalException {

  private static final long serialVersionUID = 1L;

  private NotFoundException(final IssueParent issue) {
    super(issue);
  }

  public static NotFoundException errorNotFoundCountryCode(final IssueParent issue) {
    return new NotFoundException(issue);
  }
}
