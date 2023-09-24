package org.worldbank.indicatorservice.api.integration.error;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.worldbank.indicatorservice.api.constants.ApiConstants.COUNTRY_CODE_INVALID;
import static org.worldbank.indicatorservice.api.constants.ApiConstants.COUNTRY_CODE_KEY;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.worldbank.indicatorservice.api.config.SingleContainerBaseInitializer;
import org.worldbank.indicatorservice.api.constants.ApiConstants;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(initializers = SingleContainerBaseInitializer.class)
class IndicatorControllerIntegrationErrorTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void itShouldReturnHttpStatus400() throws Exception {
    MultiValueMap<String, String> params = getDefaultParams();
    RequestBuilder requestBuilder = buildRequest(params);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isNotFound())
        .andExpect(MockMvcResultMatchers.jsonPath("code", Matchers.is(3)))
        .andExpect(
            MockMvcResultMatchers.jsonPath("message", Matchers.is("The country code not found")));
  }

  private MultiValueMap<String, String> getDefaultParams() {
    final var params = new LinkedMultiValueMap<String, String>();
    params.add(COUNTRY_CODE_KEY, COUNTRY_CODE_INVALID);
    return params;
  }

  private RequestBuilder buildRequest(MultiValueMap<String, String> params) {
    return get(ApiConstants.ENDPOINT_INDICATORS)
        .queryParams(params);
  }
}