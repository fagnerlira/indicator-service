package org.worldbank.indicatorservice.api.exceptions;

public class BadRequestException extends GlobalException {

  private static final long serialVersionUID = 1L;

  private BadRequestException(final IssueParent issue) {
    super(issue);
  }

  public static BadRequestException errorParseJson() {
    return new BadRequestException(new Issue(IssueEnum.ERROR_PARSE_JSON));
  }


}
