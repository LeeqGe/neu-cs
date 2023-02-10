package com.leeq.neu.ancestor;

public class Persion implements IAT {
  
  int yob;
  
  // To return either this Person (if this Person is younger than the
  // given yob) or the given ancestry tree IAT
  IAT youngerIATHelp(IAT other, int otherYob) {
    if (this.yob > otherYob) {
      return this;
    } else {
      return other;
    }
  }
  
  @Override
  public IAT youngerIAT(IAT other) {
    return other.youngerIATHelp(this, this.yob);
  }
}
