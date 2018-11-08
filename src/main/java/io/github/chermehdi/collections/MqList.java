package io.github.chermehdi.collections;

import io.github.chermehdi.collections.exceptions.MqListIndexOutOfRangeException;
import java.util.Iterator;

/**
 * @author chermehdi
 */
public class MqList<T> implements List<T> {

  private Object[] internal = {};

  public static final int GROW_FACTOR = 2;

  private int ptr;

  public MqList() {
    ptr = 0;
  }

  public MqList(int size) {
    ptr = 0;
    internal = new Object[size];
  }

  public int size() {
    return ptr;
  }

  public T get(int index) {
    checkRange(index);
    return element(index);
  }

  public void set(int index, T element) {
    checkRange(index);
    internal[index] = element;
  }

  public Iterator<T> iterator() {
    return new MqListIterator(this);
  }

  public void add(T element) {
    if (ptr >= internal.length) {
      ensureCapacity();
    }
    internal[ptr++] = element;
  }

  private void ensureCapacity() {
    int size = internal.length == 0 ? 1: internal.length;
    Object[] temp = new Object[GROW_FACTOR * size];
    System.arraycopy(internal, 0, temp, 0, internal.length);
    internal = temp;
  }

  public void add(List<T> list) {
    for (T e : list) {
      add(e);
    }
  }

  @Override
  public boolean isEmpty() {
    return ptr == 0;
  }

  private void checkRange(int index) {
    if (index >= ptr) {
      throw new MqListIndexOutOfRangeException("index " + index + " is bigger than list capacity");
    }
  }

  // always call after check range
  @SuppressWarnings("unchecked")
  private T element(int index) {
    return (T) internal[index];
  }

  private class MqListIterator implements Iterator<T> {

    private final MqList<T> list;
    private int pt = 0;

    public MqListIterator(MqList<T> list) {
      this.list = list;
    }

    public boolean hasNext() {
      return pt < list.size();
    }

    public T next() {
      return list.get(pt++);
    }

    public void remove() {

    }
  }
}
