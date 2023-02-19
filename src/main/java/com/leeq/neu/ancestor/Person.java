package com.leeq.neu.ancestor;

import tester.Tester;

public class Person implements IAT {
  
  String name;
  int yob;
  boolean isMale;
  IAT mom;
  IAT dad;
  
  Person(String name, int yob, boolean isMale, IAT mom, IAT dad) {
    this.name = name;
    this.yob = yob;
    this.isMale = isMale;
    this.mom = mom;
    this.dad = dad;
  }
  
  /**
   * 计算已知的祖先数量，需要排除this自己
   */
  public int count() {
    return this.mom.count() + this.dad.count();
  }
  
  
  public IAT youngerIAT(IAT other) {
    return other.youngerIATHelp(this, this.yob);
  }
  
  
  public IAT youngerIATHelp(IAT other, int otherYob) {
    if (this.yob > otherYob) {
      return this;
    } else {
      return other;
    }
  }
  
  /**
   * exam 1
   */
  @Override
  public boolean containsName(String name) {
    if (this.name.equals(name)) {
      return true;
    }
    return this.mom.containsName(name) || this.dad.containsName(name);
  }
}

/**
 * 测试用例
 */
class ExamplesIAT {
  
  IAT enid = new Person("Enid", 1904, false, new Unknown(), new Unknown());
  IAT edward = new Person("Edward", 1902, true, new Unknown(), new Unknown());
  IAT emma = new Person("Emma", 1906, false, new Unknown(), new Unknown());
  IAT eustace = new Person("Eustace", 1907, true, new Unknown(), new Unknown());

  IAT david = new Person("David", 1925, true, new Unknown(), this.edward);
  IAT daisy = new Person("Daisy", 1927, false, new Unknown(), new Unknown());
  IAT dana = new Person("Dana", 1933, false, new Unknown(), new Unknown());
  IAT darcy = new Person("Darcy", 1930, false, this.emma, this.eustace);
  IAT darren = new Person("Darren", 1935, true, this.enid, new Unknown());
  IAT dixon = new Person("Dixon", 1936, true, new Unknown(), new Unknown());

  IAT clyde = new Person("Clyde", 1955, true, this.daisy, this.david);
  IAT candace = new Person("Candace", 1960, false, this.dana, this.darren);
  IAT cameron = new Person("Cameron", 1959, true, new Unknown(), this.dixon);
  IAT claire = new Person("Claire", 1956, false, this.darcy, new Unknown());

  IAT bill = new Person("Bill", 1980, true, this.candace, this.clyde);
  IAT bree = new Person("Bree", 1981, false, this.claire, this.cameron);

  IAT andrew = new Person("Andrew", 2001, true, this.bree, this.bill);

  boolean testCount(Tester t) {
      return
          t.checkExpect(this.andrew.count(), 16) &&
          t.checkExpect(this.david.count(), 1) &&
          t.checkExpect(this.enid.count(), 0) &&
          t.checkExpect(new Unknown().count(), 0);
  }
//  boolean testFemaleAncOver40(Tester t) {
//      return
//          t.checkExpect(this.andrew.femaleAncOver40(), 7) &&
//          t.checkExpect(this.bree.femaleAncOver40(), 3) &&
//          t.checkExpect(this.darcy.femaleAncOver40(), 1) &&
//          t.checkExpect(this.enid.femaleAncOver40(), 0) &&
//          t.checkExpect(new Unknown().femaleAncOver40(), 0);
//  }
//  boolean testWellFormed(Tester t) {
//      return
//          t.checkExpect(this.andrew.wellFormed(), true) &&
//          t.checkExpect(new Unknown().wellFormed(), true) &&
//          t.checkExpect(
//              new Person("Zane", 2000, true, this.andrew, this.bree).wellFormed(),
//              false);
//  }
//  boolean testAncNames(Tester t) {
//      return
//          t.checkExpect(this.david.ancNames(),
//              new ConsLoString("David",
//                  new ConsLoString("Edward", new MtLoString()))) &&
//          t.checkExpect(this.eustace.ancNames(),
//              new ConsLoString("Eustace", new MtLoString())) &&
//          t.checkExpect(new Unknown().ancNames(), new MtLoString());
//  }
//  boolean testYoungestGrandparent(Tester t) {
//      return
//          t.checkExpect(this.emma.youngestGrandparent(), new Unknown()) &&
//          t.checkExpect(this.david.youngestGrandparent(), new Unknown()) &&
//          t.checkExpect(this.claire.youngestGrandparent(), this.eustace) &&
//          t.checkExpect(this.bree.youngestGrandparent(), this.dixon) &&
//          t.checkExpect(this.andrew.youngestGrandparent(), this.candace) &&
//          t.checkExpect(new Unknown().youngestGrandparent(), new Unknown());
//  }
  
  
  /**
   * exam 1
   */
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
//  
//  void testChoose(Tester t) {
//    Switcheroo s1 = new Switcheroo(20);
//    Switcheroo s2 = new Switcheroo(16);
//    Switcheroo s3 = new Switcheroo(2510);
//    t.checkExpect(s3.choose(s1, s2), new Switcheroo(200));
//  }
  
}

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
