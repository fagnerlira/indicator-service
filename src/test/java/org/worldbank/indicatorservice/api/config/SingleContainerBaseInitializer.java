package org.worldbank.indicatorservice.api.config;

import org.jetbrains.annotations.NotNull;
import org.mockserver.client.MockServerClient;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.MockServerContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public class SingleContainerBaseInitializer
    implements ApplicationContextInitializer<ConfigurableApplicationContext> {

  private static final String MOCKSERVER_IMAGE = "mockserver/mockserver:mockserver-5.12.0";
  private static final String WORLD_BANK_URL_PROPERTY = "world-bank-url.host=%s";
  private static final String MOCKSERVER_INITIALIZATION_JSON_PATH_KEY =
      "MOCKSERVER_INITIALIZATION_JSON_PATH";
  private static final String MOCKSERVER_INITIALIZATION_JSON_PATH_VALUE =
      "mocks/{**/*.json,*.json}";
  private static final String MOCKSERVER_INITIALIZATION_JSON_FILE_PATH = "src/test/resources/mocks";
  private static final String MOCKSERVER_MOCKS_PATH = "/mocks";
  private static final String HOST_PATTERN = "%s:%s";

  public static final MockServerContainer MOCK_SERVER_CONTAINER =
      new MockServerContainer(DockerImageName.parse(MOCKSERVER_IMAGE));

  public static MockServerClient MOCK_SERVER_CLIENT = null;

  @Override
  public void initialize(
      final @NotNull ConfigurableApplicationContext configurableApplicationContext) {
    setUpAndStartMockServer();
    createDefaultMockClient();
    applyTestPropertyValues(configurableApplicationContext);
  }

  private void setUpAndStartMockServer() {
    MOCK_SERVER_CONTAINER.withFileSystemBind(
        MOCKSERVER_INITIALIZATION_JSON_FILE_PATH, MOCKSERVER_MOCKS_PATH, BindMode.READ_ONLY);
    MOCK_SERVER_CONTAINER.addEnv(
        MOCKSERVER_INITIALIZATION_JSON_PATH_KEY, MOCKSERVER_INITIALIZATION_JSON_PATH_VALUE);

    MOCK_SERVER_CONTAINER.start();
  }

  private void createDefaultMockClient() {
    MOCK_SERVER_CLIENT =
        new MockServerClient(
            SingleContainerBaseInitializer.MOCK_SERVER_CONTAINER.getHost(),
            SingleContainerBaseInitializer.MOCK_SERVER_CONTAINER.getServerPort());
  }

  private void applyTestPropertyValues(
      final @NotNull ConfigurableApplicationContext configurableApplicationContext) {
    final var testPropertyValues = getTestPropertyValues();
    testPropertyValues.applyTo(configurableApplicationContext);
  }

  private TestPropertyValues getTestPropertyValues() {
    final String worldBankUrlProperty = getWorldBankHostProperty();
    return TestPropertyValues.of(worldBankUrlProperty);
  }

  private String getWorldBankHostProperty() {
    final var mockServerHost = getMockserverHost();
    return String.format(WORLD_BANK_URL_PROPERTY, mockServerHost);
  }

  private String getMockserverHost() {
    return String.format(
        HOST_PATTERN, MOCK_SERVER_CONTAINER.getHost(), MOCK_SERVER_CONTAINER.getServerPort());
  }
}
