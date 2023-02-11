package com.leeq.neu.ancestor;

public class Unknown implements IAT {
  
  
  @Override
  public IAT youngerIAT(IAT other) {
    return other;
  }
  
  @Override
  public IAT youngerIATHelp(IAT other, int otherYob) {
    return other;
  }
}
