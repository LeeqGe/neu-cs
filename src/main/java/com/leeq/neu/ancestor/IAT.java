package com.leeq.neu.ancestor;

/**
 * ancestor tree 祖先树
 */
public interface IAT {
  
  boolean containsName(String name);
  
  IAT youngerIAT(IAT other);
  
  IAT youngerIATHelp(IAT other, int otherYob);
  
  
}
