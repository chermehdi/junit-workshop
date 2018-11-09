package io.github.chermehdi.collections;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

/**
 * @author chermehdi
 */
public class Main {

  public static void main(String[] args) {
    Method[] methods = Assertions.class.getDeclaredMethods();
    Arrays.stream(methods).map(method -> method.toString()).map(
        method -> method
            .replaceAll("public static java.lang.Object org.junit.jupiter.api.Assertions.", "")
    ).map(
        method -> method.replaceAll("public static void org.junit.jupiter.api.Assertions.", "")
    )
        .distinct()
        .forEach(System.out::println);
  }
}
