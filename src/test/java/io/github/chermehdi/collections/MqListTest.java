package io.github.chermehdi.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author chermehdi
 */
class MqListTest {

  private List<Integer> list;

  @BeforeEach
  void setUp() {
    list = new MqList<>();
  }

  @Test
  void listIsNotNull() {
    assertNotNull(list);
  }

  @Test
  void shouldBeEmptyWhenCreated() {
    assertTrue(list.isEmpty());
    assertEquals(0, list.size());
  }

  @Test
  void shouldIncrementSizeWhenElementAdded() {
    assertEquals(0, list.size());
    list.add(1);
    assertEquals(1, list.size());
  }

  @Test
  void shouldGetElementByIndex() {
    assertEquals(0, list.size());
    list.add(1);
    assertEquals(1, list.size());
    assertEquals(1, (int) list.get(0));
    list.add(2);
    assertEquals(2, (int) list.get(1));
  }

  @Test
  void shouldGetElementByIndexWhenAddingALot() {
    for (int i = 0; i < 10; ++i) {
      list.add(i);
    }
    for (int i = 0; i < 10; ++i) {
      assertEquals(i, (int) list.get(i));
    }
  }

  @Test
  void shouldThrowAnExceptionInCaseOfOutOfBoundsIndex() {
    for (int i = 0; i < 10; ++i) {
      list.add(i);
    }

    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.get(list.size() + 1);
    });
  }

  @Test
  void shouldHaveIterator() {
    for (int i = 0; i < 10; ++i) {
      list.add(i);
    }
    Iterator<Integer> iterator = list.iterator();
    int cur = 0;
    while (iterator.hasNext()) {
      assertEquals(cur, (int) iterator.next());
      cur++;
    }
  }

  @Test
  void shouldHaveSetMethod() {
    for (int i = 0; i < 10; ++i) {
      list.add(i);
    }
    list.set(1, 21);
    assertEquals(21, (int) list.get(1));
    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.set(list.size() + 10, 35);
    });
  }

  @Test
  void shouldAddAll() {
    List<Integer> other = new MqList<>();
    list.add(1);
    for (int i = 0; i < 10; ++i) {
      other.add(i);
    }
    list.add(other);
    assertEquals(list.size(), 1 + other.size());
  }

  @Test
  void shouldBePerformant() {
    assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
      for(int i = 0; i < 100000; ++i) {
        list.add(i);
      }
    });
  }
}
