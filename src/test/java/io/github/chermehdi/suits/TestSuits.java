package io.github.chermehdi.suits;

import io.github.chermehdi.LifeCycleTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author chermehdi
 */
@RunWith(JUnitPlatform.class)
@SelectClasses({LifeCycleTest.class})
@ExcludeTags("slow")
public class TestSuits {

}
