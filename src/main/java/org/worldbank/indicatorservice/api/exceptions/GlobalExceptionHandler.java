package org.worldbank.indicatorservice.api.exceptions;

import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public Issue processExceptions(final Exception ex) {
    return new Issue(IssueEnum.UNEXPECTED_ERROR,
        Collections.singletonList(ex.getLocalizedMessage()));
  }

  @ExceptionHandler(ExternalServiceException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  protected IssueParent processExternalServiceException(final GlobalException ex) {
    return ex.getIssue();
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  protected IssueParent processNotFoundException(final GlobalException ex) {
    return ex.getIssue();
  }

  @ExceptionHandler(HttpClientErrorException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  protected IssueParent processHttpClientErrorException(final GlobalException ex) {
    return ex.getIssue();
  }

  @ExceptionHandler({BadRequestException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  protected IssueParent processBadRequestException(final GlobalException ex) {
    return ex.getIssue();
  }
}
