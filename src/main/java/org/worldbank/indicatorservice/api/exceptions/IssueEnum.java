package org.worldbank.indicatorservice.api.exceptions;

import java.util.IllegalFormatException;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum IssueEnum {
  EXTERNAL_SERVICE_ERROR(1, "Error calling external service: %s"),
  UNEXPECTED_ERROR(2, "Unexpected error. Please contact system administrator."),
  COUNTRY_CODE_NOT_FOUND(3, "The county code not found"),
  ERROR_PARSE_JSON(4, "Error parse in json");

  private final Logger logger = LogManager.getLogger(IssueEnum.class);
  private final int code;
  private final String message;

  IssueEnum(final int code, final String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getFormattedMessage(final Object... args) {
    if (message == null) {
      return StringUtils.EMPTY;
    }

    try {
      return String.format(message, args);
    } catch (final IllegalFormatException e) {
      logger.warn(e.getMessage(), e);
      return message.replace("%s", StringUtils.EMPTY);
    }
  }
}
