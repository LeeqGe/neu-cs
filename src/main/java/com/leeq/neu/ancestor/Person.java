package com.leeq.neu.ancestor;

import tester.Tester;

public class Person implements IAT {
  
  String name;
  int yob;
  
  IAT mom;
  IAT dad;
  
  public Person(String name, IAT mom, IAT dad) {
    this.name = name;
    this.mom = mom;
    this.dad = dad;
  }
  
  @Override
  public boolean containsName(String name) {
    if (this.name.equals(name)) {
      return true;
    }
    return this.mom.containsName(name) || this.dad.containsName(name);
  }
  
  

  // To return either this Person (if this Person is younger than the
  // given yob) or the given ancestry tree IAT
  @Override
  public IAT youngerIATHelp(IAT other, int otherYob) {
    if (this.yob > otherYob) {
      return this;
    } else {
      return other;
    }
  }
  
  @Override
  public IAT youngerIAT(IAT other) { //this->unknown, other->unknown
    return other.youngerIATHelp(this, this.yob);
  }
}

/**
 * exam 1
 */
class ExamplesIAT {
//  void test(Tester t) {
//    IAT davisSr = new Person("Davis", new Unknown(), new Unknown());
//    IAT edna = new Person("Edna", new Unknown(), new Unknown());
//    IAT davisJr = new Person("Davis", davisSr, edna);
//    IAT carl = new Person("Carl", new Unknown(), new Unknown());
//    IAT candace = new Person("Candace", davisJr, new Unknown());
//    IAT claire = new Person("Claire", new Unknown(), new Unknown());
//    IAT bill = new Person("Bill", carl, candace);
//    IAT bree = new Person("Bree", new Unknown(), claire);
//    IAT anthony = new Person("Anthony", bill, bree);
//
//    t.checkExpect(davisSr.containsName("Davis"), true);
//    t.checkExpect(davisSr.containsName("foo"), false);
//    t.checkExpect(edna.containsName("Edna"), true);
//    t.checkExpect(davisJr.containsName("Edna"), true);
//    t.checkExpect(candace.containsName("Davis"), true);
//    t.checkExpect(claire.containsName("Claire"), true);
//    t.checkExpect(bill.containsName("Candace"), true);
//    t.checkExpect(bree.containsName("Bree"), true);
//    t.checkExpect(anthony.containsName("Candace"), true);
//  }
  
  
  
  class Switcheroo {
    int value;
    Switcheroo(int value) {
      this.value = value;
    }
    Switcheroo choose(Switcheroo that, Switcheroo other) {
      if (this.value < that.value) {
        return other.choose(this, that);
      }
      else if (that.value > other.value) {
        return that.choose(other, new Switcheroo(this.value + 1));
      }
      else {
        return new Switcheroo(this.value * 10);
      }
    }
  }
  void testChoose(Tester t) {
    Switcheroo s1 = new Switcheroo(20);
    Switcheroo s2 = new Switcheroo(16);
    Switcheroo s3 = new Switcheroo(2510);
    t.checkExpect(s3.choose(s1, s2), new Switcheroo(200));
  }
}
