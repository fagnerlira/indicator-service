package org.worldbank.indicatorservice.api.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.util.List;
import org.worldbank.indicatorservice.api.exceptions.BadRequestException;
import org.worldbank.indicatorservice.api.validators.RequestWorldBankValidation;
import org.worldbank.indicatorservice.api.vo.request.CountryIndicatorRequest;
import org.worldbank.indicatorservice.api.vo.request.PaginationRequest;
import org.worldbank.indicatorservice.api.vo.request.WorldBankIndicatorRequest;

public class WorldBankIndicatorRequestDeserializer extends
    StdDeserializer<WorldBankIndicatorRequest> {

  private static final ObjectMapper mapper = new ObjectMapper();
  private static final RequestWorldBankValidation validation = new RequestWorldBankValidation();

  public WorldBankIndicatorRequestDeserializer() {
    this(null);
  }

  public WorldBankIndicatorRequestDeserializer(Class clazz) {
    super(clazz);
  }

  @Override
  public WorldBankIndicatorRequest deserialize(final JsonParser jsonParser,
      final DeserializationContext ctxt) {
    try {
      final JsonNode jsonNodeRoot = jsonParser.getCodec().readTree(jsonParser);
      validation.isValidReturn(jsonNodeRoot);
      return new WorldBankIndicatorRequest(getPagination(jsonNodeRoot),
          getCountryIndicatorRequests(jsonNodeRoot));
    } catch (IOException e) {
      throw BadRequestException.errorParseJson();
    }
  }

  private static List<CountryIndicatorRequest> getCountryIndicatorRequests(
      final JsonNode jsonNodeRoot) {
    try {
      return mapper.readValue(
          jsonNodeRoot.get(1).toString(), new TypeReference<>() {
          });
    } catch (JsonProcessingException e) {
      throw BadRequestException.errorParseJson();
    }
  }

  private static PaginationRequest getPagination(final JsonNode jsonNodeRoot) {
    try {
      return mapper.readValue(jsonNodeRoot.elements().next().toString(),
          PaginationRequest.class);
    } catch (JsonProcessingException e) {
      throw BadRequestException.errorParseJson();
    }
  }
}
