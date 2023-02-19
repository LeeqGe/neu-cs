//package com.leeq.neu.lst;
//
//import tester.Tester;
//
///**
// * 动物接口
// * @author leeq
// *
// */
//interface IAnimal {
//  
//  /**
//   * 脚有多少只
//   * @return
//   */
//  int feet();
//}
//
///**
// * 小兔
// * 
// * @author leeq
// *
// */
//class Rabbit implements IAnimal {
//
//  String name;
//  public double weight;
//
//  public Rabbit(String name, double weight) {
//    this.name = name;
//    this.weight = weight;
//  }
//  
//  
//  
//  public int feet() {
//    return 4;
//  }
//  
//  
//
//}
//
///**
// * 小鸡
// * 
// * @author leeq
// *
// */
//class Chicken implements IAnimal {
//
//  String name;
//  public double weight;
//
//  public Chicken(String name, double weight) {
//    this.name = name;
//    this.weight = weight;
//  }
//  
//  public int feet() {
//    return 2;
//  }
//
//}
//
///**
// * 动物列表接口
// * @author leeq
// *
// */
//interface ILoAnimal {
//
//  /**
//   * 列表基本统计
//   * @return
//   */
//  int totalWeight();
//  int rabbitCount();
//  int chickenCount();
//  
//  /**
//   * 列表排序,从小到大
//   * @return
//   */
//  ILoAnimal sortByWeight();
//  ILoAnimal insert(IAnimal a);
//}
//
///**
// * 空的动物列表
// * @author leeq
// *
// */
//class MtLoAnimal implements ILoAnimal {
//
//  public int totalWeight() {
//    return 0;
//  }
//
//  public int rabbitCount() {
//    return 0;
//  }
//
//  public int chickenCount() {
//    return 0;
//  }
//
//  public ILoAnimal sortByWeight() {
//    return this;
//  }
//
//  public ILoAnimal insert(IAnimal a) {
//    return new ConsLoAnimal(a, this);
//  }
//}
//
///**
// * 存在动物的动物列表
// * 
// * 用instanceof关键字来实现
// * 
// * @author leeq
// *
// */
//class ConsLoAnimal implements ILoAnimal {
//  
//  IAnimal first;
//  ILoAnimal rest;
//  
//  //fix
//  public ConsLoAnimal(IAnimal first, ILoAnimal rest) {
//    this.first = first;
//    this.rest = rest;
//  }
//  
//  public int totalWeight() {
//    // fix
//    return this.first.weight + this.rest.totalweight();
//  }
//
//  public int rabbitCount() {
//    return this.first.rabbitCount() + this.rest.rabbitCount();
//  }
//
//  public int chickenCount() {
//    return this.first.chickenCount() + this.rest.chickenCount();
//  }
//  
//  public ILoAnimal sortByWeight() {
//    return this.rest.sortByweight().insert(this.first);
//  }
//
//  public ILoAnimal insert(IAnimal a) {
//    if (this.first.totalweight() < a.totalweight()) {
//      return new ConsLoAnimal(this.first, this.rest.insert(a));
//    }
//    else {
//      return new ConsLoAnimal(a, this);
//    }
//  };
//}
//
//class ExamplesTest {
//
//  void test1(Tester t) {
//    // 创建一个ILoAnimal，并测试`脚`有多少只
//    
//  }
//}
