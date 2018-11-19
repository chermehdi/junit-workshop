package io.github.chermehdi.assumptions;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

/**
 * @author chermehdi
 */
class AssumptionsTest {

  @Test
  void testAssumption() {
    assumeTrue(false);
    assertTrue(false);
  }
}
