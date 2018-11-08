package io.github.chermehdi.collections.extension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.chermehdi.collections.runners.SomeOtherService;
import io.github.chermehdi.collections.runners.SomeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * test showing that we can inject any bean in the parameters of tests
 *
 * @author chermehdi
 */
@ExtendWith(InjectionExtension.class)
public class TestExtension {

  @Test
  void testExtension(SomeService service, SomeOtherService otherService) {
    assertNotNull(service);
    assertNotNull(otherService);
    System.out.println("service invoked " + service);
    assertTrue(true);
  }
}
