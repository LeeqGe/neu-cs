package com.leeq.neu.ancestor;

import tester.Tester;

class Fibonacci {
  
  int fibo(int i) {
    //终止态
    if (i == 0) {
      return 0;
    }
    if (i == 1) {
      return 1;
    }
    
    //递归
    return fibo(i-1) + fibo(i-2);
  }
  
  void test(Tester t) {
    // 0,1,1,2,3,5,8,13,21,34,55,89,...
    
    t.checkExpect(fibo(8), 21);
  }
}
