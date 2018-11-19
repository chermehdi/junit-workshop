package io.github.chermehdi.conditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author chermehdi
 */

class LuckyTest {

  @Test
  @Lucky
  void testLuck() {
    assertTrue(true);
  }

  @Test
  void testLuck1() {
    assertTrue(true);
  }
}
