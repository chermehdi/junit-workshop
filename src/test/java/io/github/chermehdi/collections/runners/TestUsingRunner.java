package io.github.chermehdi.collections.runners;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author chermehdi
 */
@RunWith(InjectionRunner.class)
public class TestUsingRunner {

  @Inject
  SomeService service;

  @Inject
  SomeOtherService serviceOther;

  @Test
  public void helloTest() {
    assertEquals("i am a service depend", service.getString());
  }

  @Test
  public void helloTestAgain() {
    assertEquals("i am a service", serviceOther.getString());
  }

}
