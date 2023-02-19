package com.leeq.neu.ancestor;

class Unknown implements IAT {
  
  public boolean containsName(String name) {
    return false;
  }
  
  public int count() {
    return 0;
  }
  
  public IAT youngerIAT(IAT other) {
    return other;
  }
  
  public IAT youngerIATHelp(IAT other, int otherYob) {
    return other;
  }
}
