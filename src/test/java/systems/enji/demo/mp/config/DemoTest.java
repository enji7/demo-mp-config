package systems.enji.demo.mp.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.util.List;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import systems.enji.demo.mp.config.api.IDemoService;

/**
 * This test requires the demo service to be up and running.
 */
public class DemoTest {

  private static IDemoService _client;

  private static final String ENDPOINT = "http://localhost:8080/demo-mp-config/";

  @BeforeAll
  static void beforeAll() {
    RestClientBuilder builder = RestClientBuilder.newBuilder().baseUri(URI.create(ENDPOINT)).register(JacksonJsonProvider.class);
    _client = builder.build(IDemoService.class);
  }

  @Test
  void string() {
    assertEquals("stringValue", _client.injected());
  }

  @Test
  void programmatic() {
    assertEquals("stringValue", _client.programmatic());
  }

  @Test
  void sysprop() {
    assertEquals("syspropValue", _client.sysprop());
  }

  @Test
  void notset() {
    assertEquals(null, _client.notset());
  }

  @Test
  void defaultValue() {
    assertEquals("defaultValue", _client.defaultValue());
  }

  @Test
  void intValue() {
    assertEquals(42, _client.intValue());
  }

  @Test
  void booleanValue() {
    assertEquals(true, _client.booleanValue());
  }

  @Test
  void list() {
    assertEquals(List.of("one", "two", "three"), _client.list());
  }

}
