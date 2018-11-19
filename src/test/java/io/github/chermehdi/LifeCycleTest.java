package io.github.chermehdi;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.chermehdi.tags.Slow;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * @author chermehdi
 */
@TestInstance(Lifecycle.PER_CLASS)
public class LifeCycleTest {

  private List<Integer> list = new ArrayList<>();

  @Test
  void testMethod1() {
    System.out.println(this + " " + list);
    list.add(1);
    assertTrue(true);
  }

  @Test
  @Slow
  void testMethod2() {
    System.out.println(this + " " + list);
    list.add(2);
    assertTrue(true);
  }

  @Test
  void testMethod3() {
    System.out.println(this + " " + list);
    assertTrue(true);
  }
}
