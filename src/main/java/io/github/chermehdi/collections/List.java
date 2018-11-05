package io.github.chermehdi.collections;

/**
 * simulation of the list data structure
 *
 * @author chermehdi
 */
public interface List<T> extends Iterable<T> {

  /**
   * @return the size of the list
   */
  int size();

  /**
   * @param index of the element you want to get
   * @return element at the specified index or throw a @{MqListIndexOutOfRangeException}
   */
  T get(int index);

  /**
   * set the value of the elmeent at given index, or throw a @{MqListIndexOutOfRangeException}
   */
  void set(int index, T element);

  /**
   * append given element to the end of the list
   *
   * @param element element to be added
   */
  void add(T element);

  /**
   * append the list of the elements to the end of the list
   */
  void add(List<T> addAll);
}
