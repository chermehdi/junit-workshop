package io.github.chermehdi.factories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

/**
 * @author chermehdi
 */
class TestFactories {


  @DisplayName("generating 3 random tests 🤣")
  @TestFactory
  Collection<DynamicTest> testGenerator() {
    return Arrays.asList(
        DynamicTest.dynamicTest("test number " + 1, () -> {
          assertTrue(true);
        }),
        DynamicTest.dynamicTest("test number " + 2, () -> {
          assertTrue(true);
        }),
        DynamicTest.dynamicTest("test number " + 3, () -> {
          assertTrue(true);
        })
    );
  }

  @DisplayName("generating 3 random tests 🤣")
  @TestFactory
  Stream<DynamicTest> testGeneratorStream() {
    Iterator<String> iterator = Arrays.asList("1", "2", "3").iterator();
    Function<String, String> messageGenrator = (in) ->  "running " + in;
    return DynamicTest.stream(iterator, messageGenrator, (in) -> {
      assertTrue(canParseInteger(in));
    });
  }

  private boolean canParseInteger(String in) {
    try {
      Integer.parseInt(in);
      return true;
    }catch (Exception e) {
      return false;
    }
  }
}
