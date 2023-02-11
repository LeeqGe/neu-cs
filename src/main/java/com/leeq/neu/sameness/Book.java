package com.leeq.neu.sameness;

import java.util.Objects;

public class Book {
  
  String title;
  Author author;
  
  public Book() {
  }
  
  Book(String title, Author author) {
    this.title = title;
    this.author = author;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) return false;
    Book book = (Book) obj;
    //NULL
    return book.title.equals(this.title) && book.author.equals(this.author);
  }
  
  // In Book
//  boolean sameBook(Book that) {
//    return this.title.equals(that.title) && this.author.equals(that.author);
//  }
  
  boolean sameBook(Book that) {
    return this.title.equals(that.title) && this.author.equals(that.author);
  }
  
  static class Author {
  
    String firstName;
    String lastName;
    
    public Author(String f, String l) {
      this.firstName = f;
      this.lastName = l;
    }
    
    boolean equals(Author o) {
      return this.firstName.equals(o.firstName) && this.lastName.equals(o.lastName);
    }
  
    /**
     * instanceof
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
//      if (o == null || getClass() != o.getClass()) return false;
      if (o == null || !(o instanceof Author)) {
        return false;
      }
      Author author = (Author) o;
      return Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName);
    }
  
//    @Override
//    public int hashCode() {
//      return Objects.hash(firstName, lastName);
//    }
  
    public static void main(String[] args) {
      //== equals方法
      Book book1 = new Book("book", new Author("1", "2"));
      Book book2 = new Book("book", new Author("1", "2"));
      
      System.out.println(book1 == book2);
      System.out.println(book1.equals(book2));
    }
  }
  //ctrl + /
}
