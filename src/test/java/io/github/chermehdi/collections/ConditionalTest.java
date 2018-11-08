package io.github.chermehdi.collections;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.OS;

/**
 * @author chermehdi
 */
@DisplayName("Testing conditionally")
class ConditionalTest {


  /**
   * maybe a failing service that you don't wanna deal with just now
   */
  @Test
  @Disabled
  void shouldNotRunForNow() {
    fail("this is still failing");
  }

  /**
   * maybe testing as service that just don't work on windows
   */
  @Test
  @DisabledOnOs(OS.WINDOWS)
  void shouldRunOnlyIfNotWindows() {
    assertSame(true, true);
  }

  /**
   * this runs only if a given logic is evaluated to true
   */
  @Test
  @EnabledIf("Math.random() > 0.5")
  void shouldRunIfConditionIsMet() {
    assertTrue(true);
  }

  /**
   * will only get executed if you have a 64bit os version
   */
  @Test
  @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
  void onlyOn64BitArchitectures() {
    assertTrue(true);
  }

  /**
   * this will only get triggered if an environment variable called test.env is not present
   */
  @Test
  @DisabledIfEnvironmentVariable(named = "test.env", matches = "test")
  void notOnDeveloperWorkstation() {
    assertTrue(true);
  }
}
