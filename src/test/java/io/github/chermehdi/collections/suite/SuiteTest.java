package io.github.chermehdi.collections.suite;

import io.github.chermehdi.collections.extension.TestExtension;
import io.github.chermehdi.collections.runners.TestUsingRunner;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * @author chermehdi
 */
@RunWith(JUnitPlatform.class)
@SelectClasses({TestExtension.class, TestUsingRunner.class})
public class SuiteTest {

}
