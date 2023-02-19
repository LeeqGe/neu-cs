package com.leeq.neu.clazz;

import tester.*;

interface IShape {
  // to compute the area of this shape
  double area();

  // to compute the distance form this shape to the origin
  double distToOrigin();

  // to increase the size of this shape by the given increment
  IShape grow(int inc);

  // is the area of this shape bigger than the area of the given shape?
//  boolean biggerThan(IShape that);

  // does this shape (including the boundary) contain the given point?
  boolean contains(CartPt pt);
}

//to represent a Cartesian point
class CartPt {
  int x;
  int y;

  CartPt(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // to compute the distance form this point to the origin
  public double distToOrigin() {
    return Math.sqrt(this.x * this.x + this.y * this.y);
  }

  // to compute the distance form this point to the given point
  public double distTo(CartPt pt) {
    return Math.sqrt((this.x - pt.x) * (this.x - pt.x) + (this.y - pt.y) * (this.y - pt.y));
  }
}

// to represent a circle
class Circle implements IShape {
  CartPt center;
  int radius;
  String color;

  Circle(CartPt center, int radius, String color) {
    this.center = center;
    this.radius = radius;
    this.color = color;
  }

  // to compute the area of this shape
  public double area() {
    return Math.PI * this.radius * this.radius;
  }

  // to compute the distance form this shape to the origin
  public double distToOrigin() {
    return this.center.distToOrigin() - this.radius;
  }

  // to increase the size of this shape by the given increment
  public IShape grow(int inc) {
    return new Circle(this.center, this.radius + inc, this.color);
  }

  // is the area of this shape bigger than the area of the given shape?
  public boolean biggerThan(IShape that) {
    return this.area() >= that.area();
  }

  // does this shape (including the boundary) contain the given point?
  public boolean contains(CartPt pt) {
    return this.center.distTo(pt) <= this.radius;
  }

}

// to represent a square
class Square implements IShape {
  CartPt nw;
  int size;
  String color;

  Square(CartPt nw, int size, String color) {
    this.nw = nw;
    this.size = size;
    this.color = color;
  }

  // to compute the area of this shape
  public double area() {
    return this.size * this.size;
  }

  // to compute the distance form this shape to the origin
  public double distToOrigin() {
    return this.nw.distToOrigin();
  }

  // to increase the size of this shape by the given increment
  public IShape grow(int inc) {
    return new Square(this.nw, this.size + inc, this.color);
  }

  // is the area of this shape bigger than the area of the given shape?
  public boolean biggerThan(IShape that) {
    return this.area() >= that.area();
  }

  // does this shape (including the boundary) contain the given point?
  public boolean contains(CartPt pt) {
    return (this.nw.x <= pt.x) && (pt.x <= this.nw.x + this.size) && (this.nw.y <= pt.y)
        && (pt.y <= this.nw.y + this.size);
  }
}

class ComboShape implements IShape {
  IShape first;
  IShape second;

  public ComboShape(IShape first, IShape second) {
    this.first = first;
    this.second = second;
  }

  public double area() {
    return first.area() + second.area();
  }

  public double distToOrigin() {
    return Math.min(this.first.distToOrigin(), this.second.distToOrigin());
  }

  public IShape grow(int inc) {
    return new ComboShape(this.first.grow(inc), this.second.grow(inc));
  }

  public boolean contains(CartPt pt) {
    return this.first.contains(pt) || this.second.contains(pt);
  }
}

class ExamplesShapes {
  ExamplesShapes() {
  }

  CartPt pt1 = new CartPt(0, 0);
  CartPt pt2 = new CartPt(3, 4);
  CartPt pt3 = new CartPt(7, 1);

  IShape c1 = new Circle(new CartPt(50, 50), 10, "red");
  IShape c2 = new Circle(new CartPt(50, 50), 30, "red");
  IShape c3 = new Circle(new CartPt(30, 100), 30, "blue");

  IShape s1 = new Square(new CartPt(50, 50), 30, "red");
  IShape s2 = new Square(new CartPt(50, 50), 50, "red");
  IShape s3 = new Square(new CartPt(20, 40), 10, "green");
  
  // todo add test case
  void test(Tester t) {
    Square sq = (Square) c1;
  }
}