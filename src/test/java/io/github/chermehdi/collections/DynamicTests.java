package io.github.chermehdi.collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author chermehdi
 */
public class DynamicTests {

  @TestFactory
  Collection<DynamicTest> dynamics() {
    return IntStream.range(0, 10)
        .mapToObj(number -> DynamicTest.dynamicTest("test " + number, () -> {
          assertTrue(number > -1);
        }))
        .collect(Collectors.toList());
  }

  @TestFactory
  Stream<DynamicTest> dynamicTestStream() {
    ThrowingConsumer<String> executor = (input) -> assertTrue(input.toLowerCase().contains("mql"));
    List<String> listOfNames = Arrays.asList("mqlteacher", "studentmql");
    Function<String, String> resolver = (name) -> "resolving test: " + name;
    return DynamicTest.stream(listOfNames.iterator(), resolver, executor);
  }

  @ParameterizedTest
  @ValueSource(strings = {"hellomql"})
  void paramTest(String input) {
    assertTrue(input.toLowerCase().contains("mql"));
  }
}
