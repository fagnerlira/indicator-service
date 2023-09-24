package org.worldbank.indicatorservice.api.integration.success;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.worldbank.indicatorservice.api.constants.ApiConstants.COUNTRY_CODE_KEY;
import static org.worldbank.indicatorservice.api.constants.ApiConstants.COUNTRY_CODE_VALUE;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.worldbank.indicatorservice.api.config.SingleContainerBaseInitializer;
import org.worldbank.indicatorservice.api.constants.ApiConstants;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(initializers = SingleContainerBaseInitializer.class)
class IndicatorControllerIntegrationSuccessTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void itShouldReturnIndicatorsSuccessfully() throws Exception {
    MultiValueMap<String, String> params = getDefaultParams();
    RequestBuilder requestBuilder = buildRequest(params);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.countryIndicator", hasSize(50)));
  }

  private MultiValueMap<String, String> getDefaultParams() {
    final var params = new LinkedMultiValueMap<String, String>();
    params.add(COUNTRY_CODE_KEY, COUNTRY_CODE_VALUE);
    return params;
  }

  private RequestBuilder buildRequest(MultiValueMap<String, String> params) {
    return get(ApiConstants.ENDPOINT_INDICATORS).queryParams(params);
  }
}