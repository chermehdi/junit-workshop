package io.github.chermehdi.conditions;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @author chermehdi
 */
public class LuckyCondition implements ExecutionCondition {

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    double result = Math.random();
    return result > .5 ? ConditionEvaluationResult.enabled("result is bigger than half")
        : ConditionEvaluationResult.disabled("result is smaller than half ");
  }
}
