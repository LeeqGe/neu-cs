package com.leeq.neu.abs;

/**
 * Abstracting over types
 * 将类型抽象设计, IList<String> instend of ILoString interface
 */
public class ConsLoString2 implements IList<String> {
  
  String first;
  IList<String> rest;
  
  
  public ConsLoString2(String first, IList<String> rest) {
    this.first = first;
    this.rest = rest;
  }
  
  @Override
  public IList<String> filter(IPred<String> pred) {
    if(pred.apply(first)) {
      return new ConsLoString2(this.first, this.rest.filter(pred));
    } else {
      return this.rest.filter(pred);
    }
  }
  
  @Override
  public IList<String> sort(IComparator<String> comp) {
    return this.rest.sort(comp).insertBy(comp, this.first);
  }
  
  @Override
  public IList<String> insertBy(IComparator comp, String s) {
    if (comp.comparator(this.first, s) < 0) {
      return new ConsLoString2(this.first, this.rest.insertBy(comp, s));
    } else {
      return new ConsLoString2(s, this);
    }
  }
}
