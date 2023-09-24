package org.worldbank.indicatorservice.api.validators;

import static org.worldbank.indicatorservice.api.contantes.ApiConstants.REQUEST_MESSAGE_ERROR;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Objects;
import org.springframework.stereotype.Component;
import org.worldbank.indicatorservice.api.exceptions.Issue;
import org.worldbank.indicatorservice.api.exceptions.IssueEnum;
import org.worldbank.indicatorservice.api.exceptions.NotFoundException;

@Component
public class RequestWorldBankValidation {

  public void isValidReturn(final JsonNode jsonNode) {
    if (Objects.nonNull(jsonNode.elements().next().get(REQUEST_MESSAGE_ERROR))) {
      throw NotFoundException.errorNotFoundCountryCode(
          new Issue(IssueEnum.COUNTRY_CODE_NOT_FOUND));
    }
  }
}
