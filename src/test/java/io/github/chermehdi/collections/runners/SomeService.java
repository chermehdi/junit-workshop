package io.github.chermehdi.collections.runners;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @author chermehdi
 */
@ApplicationScoped
public class SomeService {

  @Inject
  DependentService service;

  public String getString() {
    return "i am a service " + service.dependent();
  }
}
