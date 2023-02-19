package com.leeq.neu.sameness;

import com.leeq.neu.ancestor.IAT;

import tester.Tester;

import java.util.Objects;

/**
 * 判断对象相等
 * @author leeq
 *
 */
class Book {
  String title;
  Author author;
  
  public Book() {
  }
  
  /**
   * 常量使用(跨java包访问)
   * 
   * @param title
   * @param author
   */
  Book(String title, Author author) {
    System.out.println(IAT.SCREEN_HEIGHT);
    this.title = title;
    this.author = author;
  }
  
//  扩展知识，所有的类都是java Object这个基类的子类，基类Object含equals方法
//  public boolean equals(Object obj) {
//    if (obj == null || getClass() != obj.getClass()) return false;
//    Book book = (Book) obj;
//    //NULL
//    return book.title.equals(this.title) && book.author.equals(this.author);
//  }
  
  public boolean sameBook(Book that) {
    return this.title.equals(that.title) && this.author.equals(that.author);
  }
}

class Author {
  
  String firstName;
  String lastName;
  
  public Author(String f, String l) {
    this.firstName = f;
    this.lastName = l;
  }
  
  public boolean equals(Author o) {
    return this.firstName.equals(o.firstName) && this.lastName.equals(o.lastName);
  }

//  扩展知识，判断值相等一般用基于Object的equals方法，这里是重写父类的equals方法
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || !(o instanceof Author)) {
//      return false;
//    }
//    Author author = (Author) o;
//    return Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName);
//  }

//  扩展知识，判断值和内存地址均相等会调用此方法。 java用 == 来表示完全相等
//  public int hashCode() {
//    return Objects.hash(firstName, lastName);
//  }

}

class ExamplesTest {
  
  void test(Tester t) {
    Book book1 = new Book("book", new Author("1", "2"));
    Book book2 = new Book("book", new Author("1", "2"));
    
    t.checkExpect(true, book1.sameBook(book2));
    t.checkExpect(false, book1 ==  book2);
    
    System.out.println("hashCode book1: " + book1.hashCode());
    System.out.println("hashCode book2: " + book2.hashCode());

  }
}