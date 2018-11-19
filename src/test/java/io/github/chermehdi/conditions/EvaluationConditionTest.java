package io.github.chermehdi.conditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author chermehdi
 */
class EvaluationConditionTest {

  @Test
  @Evaluate("1 + 3 == 2")
  void executeIfScriptIsCorrect() {
    assertTrue(true);
  }
}
