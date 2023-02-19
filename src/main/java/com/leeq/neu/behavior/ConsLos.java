package com.leeq.neu.behavior;

/**
 * Abstracting over types
 * 将类型抽象设计, IList<String> instend of ILoString interface
 */
class ConsLos implements IList<String> {
  
  String first;
  IList<String> rest;
  
  
  public ConsLos(String first, IList<String> rest) {
    this.first = first;
    this.rest = rest;
  }
  
  @Override
  public IList<String> filter(IPred<String> pred) {
    if(pred.apply(first)) {
      return new ConsLos(this.first, this.rest.filter(pred));
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
      return new ConsLos(this.first, this.rest.insertBy(comp, s));
    } else {
      return new ConsLos(s, this);
    }
  }
}
