package org.worldbank.indicatorservice.api.validators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.worldbank.indicatorservice.api.exceptions.NotFoundException;

@ExtendWith(MockitoExtension.class)
class RequestWorldBankValidationTest {

  @InjectMocks
  private RequestWorldBankValidation validation;


  @Test
  void itShouldThrowNotFoundException() throws JsonProcessingException {
    final var message = "[{\n"
        + "          \"message\": [\n"
        + "            {\n"
        + "              \"id\": \"120\",\n"
        + "              \"key\": \"Invalid value\",\n"
        + "              \"value\": \"The provided parameter value is not valid\"\n"
        + "            }\n"
        + "          ]\n"
        + "        }]";
    final ObjectMapper mapper = new ObjectMapper();
    final JsonNode jsonNode = mapper.readValue(message, JsonNode.class);

    final NotFoundException exception = assertThrows(
        NotFoundException.class, () ->
            validation.isValidReturn(jsonNode)
    );
    assertEquals(3, exception.getIssue().getCode());
    assertEquals("The county code not found", exception.getIssue().getMessage());
  }

  @Test
  void itShouldDoesNotThrowException() throws JsonProcessingException {
    final var message = "[\n"
        + "        {\n"
        + "          \"page\": 1,\n"
        + "          \"pages\": 2,\n"
        + "          \"per_page\": 50,\n"
        + "          \"total\": 63,\n"
        + "          \"sourceid\": \"2\",\n"
        + "          \"lastupdated\": \"2023-09-19\"\n"
        + "        },\n"
        + "        [\n"
        + "          {\n"
        + "            \"indicator\": {\n"
        + "              \"id\": \"SI.POV.DDAY\",\n"
        + "              \"value\": \"Poverty headcount ratio at $2.15 a day (2017 PPP) (% of population)\"\n"
        + "            },\n"
        + "            \"country\": {\n"
        + "              \"id\": \"BR\",\n"
        + "              \"value\": \"Brazil\"\n"
        + "            },\n"
        + "            \"countryiso3code\": \"BRA\",\n"
        + "            \"date\": \"2022\",\n"
        + "            \"value\": null,\n"
        + "            \"unit\": \"\",\n"
        + "            \"obs_status\": \"\",\n"
        + "            \"decimal\": 1\n"
        + "          }]]";
    final ObjectMapper mapper = new ObjectMapper();
    final JsonNode jsonNode = mapper.readValue(message, JsonNode.class);

    Assertions.assertDoesNotThrow(() ->
        validation.isValidReturn(jsonNode)
    );
  }
}