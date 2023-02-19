package com.leeq.neu.ancestor;

/**
 * ancestor tree 祖先树
 */
public interface IAT {
  
  int count();
  
  /**
   * 常量的一种定义方法
   */
  int SCREEN_HEIGHT = 30;
  
  boolean containsName(String name);
  
  IAT youngerIAT(IAT other);
  
  IAT youngerIATHelp(IAT other, int otherYob);
  
  
}
