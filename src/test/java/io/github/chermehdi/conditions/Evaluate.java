package io.github.chermehdi.conditions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author chermehdi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@ExtendWith(EvaluationCondition.class)
public @interface Evaluate {

  String value();
}
