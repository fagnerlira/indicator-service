package org.worldbank.indicatorservice.api.exceptions;

public class ExternalServiceException extends GlobalException {

  private static final long serialVersionUID = 1L;

  private ExternalServiceException(final Issue issue) {
    super(issue);
  }

  public static ExternalServiceException errorCallingExternalService(final IssueEnum issueEnum,
      final String value) {
    return new ExternalServiceException(new Issue(issueEnum, value));
  }
}
