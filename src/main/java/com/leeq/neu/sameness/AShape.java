package com.leeq.neu.sameness;

import tester.Tester;

/**
 * 用双重分派，判断相等
 * @author leeq
 *
 */
interface IShape {

  default boolean sameShape(IShape that) {
    return false;
  }

  // Defining sameness
  boolean sameCircle(Circle that);

  boolean sameRect(Rect that);

  boolean sameSquare(Square that);

}

// to represent a geometric shape
abstract class AShape implements IShape {
  CartPt loc;
  String color;

  AShape(CartPt loc, String color) {
    this.loc = loc;
    this.color = color;
  }
}

// to represent a circle
class Circle extends AShape {
  int radius;

  Circle(CartPt center, int radius, String color) {
    super(center, color);
    this.radius = radius;
  }
  
  public boolean sameShape(IShape that) {
    return that.sameCircle(this);
  }

  public boolean sameCircle(Circle that) {
    return that.loc.samePoint(this.loc) && that.radius == this.radius;
  }

  public boolean sameRect(Rect that) {
    return false;
  }

  public boolean sameSquare(Square that) {
    return false;
  }

}

// to represent a rectangle
class Rect extends AShape {
  int width;
  int height;

  Rect(CartPt nw, int width, int height, String color) {
    super(nw, color);
    this.width = width;
    this.height = height;
  }

//  /**
//   * Defining sameness
//   * @param that
//   * @return
//   */
//  public boolean sameShape(IShape that) {
//    if (that instanceof Rect) {
//      // that is-a Rect -- we can safely cast!
//      return this.sameRect((Rect)that);
//    }
//    else {
//      // that is not a Rect
//      return false;
//    }
//  }

  /**
   * 双重分派 Defining sameness
   * 
   * @param that
   * @return
   */
  public boolean sameShape(IShape that) {
    return that.sameRect(this);
  }

  public boolean sameCircle(Circle that) {
    return false;
  }

  public boolean sameRect(Rect that) {
    return this.loc.samePoint(that.loc) && this.width == that.width && this.height == that.height;
  }

  public boolean sameSquare(Square that) {
    return false;
  }
}

//to represent a square
class Square extends Rect {

  Square(CartPt nw, int size, String color) {
    super(nw, size, size, color);
  }

  /**
   * 双重分派 Defining sameness
   * 
   * @param that
   * @return
   */
  public boolean sameShape(IShape that) {
    return that.sameShape(this);
  }

  public boolean sameCircle(Circle that) {
    return false;
  }

  public boolean sameRect(Rect that) {
    return false;
  }

  public boolean sameSquare(Square that) {
    return this.loc.samePoint(that.loc) && this.width == that.width;
  }
}

// to represent a Cartesian point
class CartPt {
  int x;
  int y;

  CartPt(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Defining sameness
   *
   * Define the method samePoint for the CartPt class.
   * 
   * @param that
   * @return
   */
  boolean samePoint(CartPt that) {
    return this.x == that.x && this.y == that.y;
  }
}

class ExamplesShapes {
  ExamplesShapes() {
  }

  IShape s1 = new Square(new CartPt(50, 50), 30, "red");
  IShape r1 = new Rect(new CartPt(50, 50), 30, 30, "red");

  /**
   * Defining sameness
   * 
   * @param t
   * @return
   */
  void testSameness(Tester t) {
    System.out.println(s1 instanceof Rect); // true
    IShape sr1 = (Rect) s1; // OK
    
    t.checkExpect(s1.sameShape(r1), false); // Good
    t.checkExpect(r1.sameShape(s1), true); // Not so good
  }

  
  // 定义在ExamplesShapes类里头的s1, r1，方便所有方法都可以使用
  void testSomething(Tester t) {
    System.out.println(s1);
  }
}
