package com.leeq.neu.behavior;

/**
 * Abstracting over types
 * java 泛型语法
 * @param <T>
 */
public interface IList<T> {
  
  IList<T> filter(IPred<T> pred);
  
  IList<T> sort(IComparator<T> comp);
  
  IList<T> insertBy(IComparator comp, T s);
}

/**
 * Abstracting over behavior
 * @param <T>
 */
interface IPred<T> {
  boolean apply(T obj);
}

/**
 * Abstracting over behavior
 * @param <T>
 */
interface IComparator<T> {
  //<0, 0, >0
  int comparator(T a, T b);
}
