package io.github.chermehdi.parametrized;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author chermehdi
 */
class ParametrizedTests {

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void testNumbers(int value) {
    System.out.println("The value of the test " + value);
    assertTrue(value < 10);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
  void testNumbersFile(int id, String name, int age) {
    System.out.println("the value of the input " + id + " " + name + " " + age);
    assertTrue(true);
  }
}
