package io.github.chermehdi.collections.runners;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * @author chermehdi
 */
public class InjectionRunner extends BlockJUnit4ClassRunner {

  private SeContainer container;

  /**
   * Creates a BlockJUnit4ClassRunner to run {@code klass}
   *
   * @throws InitializationError if the test class is malformed.
   */
  public InjectionRunner(Class<?> klass) throws InitializationError {
    super(klass);
    SeContainerInitializer initializer = SeContainerInitializer.newInstance();
    container = initializer.initialize();
  }

  /**
   * inject the dependencies of the given object
   */
  @Override
  protected Object createTest() throws Exception {
    Object test = super.createTest();
    return container.select(test.getClass()).get();
  }
}
