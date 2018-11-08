package io.github.chermehdi.collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * same behaviour can be achieved with -Djunit.jupiter.testinstance.lifecycle.default=per_method
 *
 * @author chermehdi
 */
//@TestInstance(Lifecycle.PER_METHOD)
public class InstanceLifecycleTest {

  @Test
  void firstTest() {
    System.out.println(System.identityHashCode(this));
    assertTrue(true);
  }

  @Test
  void secondTest() {
    System.out.println(System.identityHashCode(this));
    assertTrue(true);
  }

  @Test
  void thirdTest() {
    System.out.println(System.identityHashCode(this));
    assertTrue(true);
  }
}
