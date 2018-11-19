package io.github.chermehdi.conditions;

import java.lang.reflect.Method;
import javax.script.ScriptEngineManager;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @author chermehdi
 */
public class EvaluationCondition implements ExecutionCondition {

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    String script = context.getTestMethod().map(method ->
        method.getAnnotation(Evaluate.class).value()).orElse("");
    ScriptEngineManager manager = new ScriptEngineManager();
    try {
      Object result = manager.getEngineByName("Nashorn").eval(script);
      boolean evaluationResult = (Boolean) result;
      return evaluationResult ? ConditionEvaluationResult.enabled("")
          : ConditionEvaluationResult.disabled("script evaluated to false");
    } catch (Exception e) {
      return ConditionEvaluationResult.disabled("could not evaluate the script " + script);
    }
  }
}
