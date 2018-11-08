package io.github.chermehdi.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.github.chermehdi.collections.exceptions.MqListIndexOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author chermehdi
 */
class MqListTest {

  @Test
  void size() {
    List<Integer> list = new MqList<>();
    assertEquals(0, list.size());
    list.add(1);
    list.add(2);
    assertEquals(2, list.size());
  }

  @Test
  @DisplayName("get should retrieve items")
  void get() {
    List<Integer> list = new MqList<>();
    list.add(10);
    list.add(12);
    assertEquals(10, (int)list.get(0));
    assertEquals(12, (int)list.get(1));
  }

  @Test
  void set() {
    List<Integer> list = new MqList<>();
    list.add(10);
    assertEquals(10, (int)list.get(0));
    list.set(0, 12);
    assertEquals(12, (int)list.get(0));
  }

  @Test
  void addAll() {
    List<Integer> list = new MqList<>();
    list.add(10);
    list.add(12);
    List<Integer> bigger = new MqList<>();
    bigger.add(1);
    bigger.add(list);
    assertEquals(3, bigger.size());
    assertEquals(1, (int)bigger.get(0));
    assertEquals(10, (int)bigger.get(1));
    assertEquals(12, (int)bigger.get(2));
  }

  @Test
  void getShouldThrowExceptions() {
    List<Integer> list = new MqList<>();
    list.add(10);
    assertThrows(MqListIndexOutOfRangeException.class, () -> list.get(12));
  }
}