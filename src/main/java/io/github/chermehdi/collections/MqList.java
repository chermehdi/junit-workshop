package io.github.chermehdi.collections;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author chermehdi
 */
public class MqList<T> implements List<T> {

  private Object[] internal;

  private static final int GROWING_FACTOR = 2;

  private int ptr = 0;

  public MqList() {
    internal = new Object[2];
  }

  @Override
  public int size() {
    return ptr;
  }

  @Override
  public T get(int index) {
    checkRange(index);
    return (T) internal[index];
  }

  private void checkRange(int index) {
    if (index >= size()) {
      throw new IndexOutOfBoundsException("index out of bounds " + index);
    }
  }

  @Override
  public void set(int index, T element) {
    checkRange(index);
    internal[index] = element;
  }

  @Override
  public void add(T element) {
    if (shouldGrow()) {
      grow();
    }
    internal[ptr++] = element;
  }

  @Override
  public void add(List<T> addAll) {
    for(T element: addAll) add(element);
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public Iterator<T> iterator() {
    return new MqListIterator<>(this);
  }

  private boolean shouldGrow() {
    return ptr + 1 >= internal.length;
  }

  private void grow() {
    Object[] temp = new Object[internal.length * GROWING_FACTOR];
    System.arraycopy(internal, 0, temp, 0, internal.length);
    internal = temp;
  }

  private class MqListIterator<T> implements Iterator<T> {

    private MqList<T> ts;

    private int ptr = 0;

    public MqListIterator(MqList<T> ts) {
      this.ts = ts;
    }

    @Override
    public boolean hasNext() {
      return ptr < ts.size();
    }

    @Override
    public T next() {
      return ts.get(ptr++);
    }
  }
}
