package com.leeq.neu.ancestor;

public class Unknown implements IAT {
  
  @Override
  public boolean containsName(String name) {
    return false;
  }
  
  @Override
  public IAT youngerIAT(IAT other) {
    return other;
  }
  
  @Override
  public IAT youngerIATHelp(IAT other, int otherYob) {
    return other;
  }
}
