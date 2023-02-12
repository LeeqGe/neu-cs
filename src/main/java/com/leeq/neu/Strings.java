package com.leeq.neu;// CS 2510, Assignment 3

import tester.*;

// to represent a list of Strings
interface ILoString {
  
  // combine all Strings in this list into one
  String combine();
  
  // produces a new list, sorted in alphabetical order
  ILoString sort();
    
  // sort helper 
  ILoString insert(String given);
    
  // determines whether this list is sorted in alphabetical order
  boolean isSorted();
    
  // isSorted helper that checks if the String matches the string in the sorted list
  boolean isSortedHelper(String given);
    
  // produces a list where the first, third, fifth... elements are from 
  // this list, and the second, fourth, sixth... elements are from the given 
  // list. Any “leftover” elements should just be left at the end.
  ILoString interleave(ILoString given);
    
  // merge two sorted lists together 
  ILoString merge(ILoString given);
    
  // merge helper
  ILoString mergeHelper(String given);
    
  // reverses the order of the list 
  ILoString reverse();
    
  // get the last String 
  ILoString revert(String given);
    
  // determines if this list contains pairs of identical strings, 
  boolean isDoubledList();
    
  // isDoubled helper 
  boolean isDoubledListHelper(String given);
  
  //gets the number of strings in a list 
  int list();
    
  // determines whether this list contains the same words reading the list in either order
  boolean isPalindromeList();
    
    
}

// to represent an empty list of Strings
class MtLoString implements ILoString {
  MtLoString(){}
    
  // combine all Strings in this list into one
  public String combine() {
    return "";
    
  }  
  
  // produces a new list, sorted in alphabetical order
  public ILoString sort() {
    return this;
    
  }
    
  // sort helper
  public ILoString insert(String given) {
    return new ConsLoString(given, new MtLoString());
    
  }
    
  // determines whether this list is sorted in alphabetical order
  public boolean isSorted() {
    return true;
    
  }
    
  // isSorted Helper 
  public boolean isSortedHelper(String given) {
    return true;
    
  }
    
  // produces a list of the odd elements of this list 
  // and the evens from the given list and the leftovers after
  public ILoString interleave(ILoString given) {
    return given;
   
  }
    
  // merge two sorted lists together 
  public ILoString merge(ILoString given) {
    return given;
    
  }
    
  // merge helper 
  public ILoString mergeHelper(String given) {
    return new ConsLoString(given, this);
    
  }
    
  // reverses the order of the list 
  public ILoString reverse() {
    return this;
  
  }
    
  // gets the last String 
  public ILoString revert(String given) {
    return new ConsLoString(given, this);
    
  }
    
  // determines if this list contains pairs of identical strings, 
  public boolean isDoubledList() {
    return true;
    
  }
    
  // helper for isDoubled
  public boolean isDoubledListHelper(String given) {
    return false;
  }
    
  //gets the number of strings in a list 
  public int list() {
    return 0;
  }
  
  // determines whether this list contains the same words reading the list in either order
  public boolean isPalindromeList() {
    return true;
    
  }

    
}

// to represent a nonempty list of Strings
class ConsLoString implements ILoString {
  String first;
  ILoString rest;
  
  ConsLoString(String first, ILoString rest) {
    this.first = first;
    this.rest = rest;  
  }
    
  /*
   TEMPLATE
   FIELDS:
   ... this.first ...                                         -- String
   ... this.rest ...                                          -- ILoString
     
   METHODS
   ... this.combine() ...                                     -- String
   ... this.sort() ...                                        -- ILoString
   ... this.insert(String given) ...                          -- ILoString
   ... this.isSorted() ...                                    -- boolean
   ... this.isSortedHelper(String given) ...                  -- boolean
   ... this.interleave(ILoString given) ...                   -- ILoString
   ... this.merge(ILoString given) ...                        -- ILoString
   ... this.mergeHelper(String given) ...                     -- ILoString
   ... this.reverse() ...                                     -- ILoString
   ... this.revert(String given) ...                          -- ILoString
   ... this.isDoubledList(String given) ...                   -- boolean
   ... this.isDoubledListHelper() ...                         -- boolean
   ... this.isPalindrome() ...                                -- boolean
     
   METHODS FOR FIELDS
   ... this.first.concat(String given) ...                     -- String
   ... this.first.compareTo(String given) ...                  -- int
   ... this.rest.combine() ...                                 -- String
   ... this.rest.sort() ...                                    -- ILoString
   ... this.rest.insert(String given) ...                      -- ILoString
   ... this.rest.isSorted() ...                                -- boolean
   ... this.rest.isSortedHelper(String given) ...              -- boolean
   ... this.interleave(ILoString given) ...                    -- ILoString
   ... this.rest.merge(ILoString given) ...                    -- ILoString
   ... this.rest.mergeHelper(String given) ...                 -- ILoString
   ... this.rest.reverse() ...                                 -- ILoString
   ... this.rest.revert(String given) ...                      -- ILoString
   ... this.rest.isDoubledList(String given) ...               -- boolean
     
  */
  
  // combine all Strings in this list into one
  public String combine() {
    return this.first.concat(this.rest.combine());
    
  } 
    
  // sorts the list 
  public ILoString sort() {
    return this.rest.sort().insert(this.first);
    
  }
  
  // to insert the given String into this sorted list of Strings
  public ILoString insert(String given) {
    
    /*
    TEMPLATE
    FIELDS:
    ... this.first ...                                     -- String
    ... this.rest ...                                      -- ILoString
      
    METHODS
    ... this.insert(String given) ...                      -- ILoString
    ... this.compareTo() ...                               -- ILoString
      
    METHODS FOR FIELDS
    ... the.rest.insert(ILoString given) ...               -- ILoString
    
    PARAMETERS 
    given -- String 
   */
    
    if (this.first.toLowerCase().compareTo(given.toLowerCase()) >= 0) {
      return new ConsLoString(given, this);
    } else {
      return new ConsLoString(this.first, this.rest.insert(given));
    } 
  }
  
  // determines whether this list is sorted in alphabetical order
  public boolean isSorted() {
    return this.sort().isSortedHelper(this.first) && this.rest.isSorted();
    
  }
    
  // isSorted Helper 
  public boolean isSortedHelper(String given) {
    
    /*
    TEMPLATE
    FIELDS:
    ... this.first ...                                      -- String
    ... this.rest ...                                       -- ILoString
      
    METHODS
    ... this.isSortedHelper(String given) ...               -- ILoString
    ... this.compareTo() ...                                -- int
    ... this.toLowerCase() ...                              -- String
      
    METHODS FOR FIELDS
    ... the.rest.isSortedHelper(ILoString given) ...        -- ILoString
    
    PARAMETERS 
    given -- String 
    
    METHODS FOR PARAMETERS
    ... given.toLowerCase() ...                             -- String
   */
    
    if (this.first.toLowerCase().compareTo(given.toLowerCase()) < 0) {
      return false;
    } else { 
      return this.rest.isSortedHelper(given); }
    
  }
  
  // produces a list of the odd elements of this list 
  // and the evens from the given list and the leftovers after
  public ILoString interleave(ILoString given) {
    
    /*
    TEMPLATE
    FIELDS:
    ... this.first ...                                         -- String
    ... this.rest ...                                          -- ILoString
      
    METHODS
    ... this.interleave(ILoString given) ...                   -- ILoString
      
    METHODS FOR FIELDS
    ... this.interleave(ILoString given) ...                    -- ILoString
    
    PARAMETERS 
    given -- ILoString 
    
    METHODS FOR PARAMETERS
    ... given.interleave(ILoString given) ...                                 -- String
   */
    
    return new ConsLoString(this.first, given.interleave(this.rest));
    
  }
    
  // merge two sorted lists together 
  public ILoString merge(ILoString given) {
    
    /*
    TEMPLATE
    FIELDS:
    ... this.first ...                                          -- String
    ... this.rest ...                                           -- ILoString
      
    METHODS
    ... this.toLowerCase() ...                                  -- String
    ... this.compareTo(String given) ...                        -- int
    ... this.merge(ILoString given) ...                         -- ILoString
    ... this.mergeHelper(String given) ...                      -- ILoString
      
    METHODS FOR FIELDS
    ... this.rest.merge(ILoString given) ...                    -- ILoString
    ... this.rest.mergeHelper(String given) ...                 -- ILoString
    
    PARAMETERS 
    given -- ILoString 
   */
    
    return this.rest.merge(given).mergeHelper(this.first);
    
  }
    
  // merge helper 
  public ILoString mergeHelper(String given) {
    
    /*
    TEMPLATE
    FIELDS:
    ... this.first ...                                          -- String
    ... this.rest ...                                           -- ILoString
      
    METHODS
    ... this.toLowerCase() ...                                  -- String
    ... this.compareTo(String given) ...                        -- int
    ... this.mergeHelper(String given) ...                      -- ILoString
       
    METHODS FOR FIELDS
    ... this.first.toLowerCase() ...                            -- String
    ... this.rest.mergeHelper(String) ...                       -- ILoString
    
    PARAMETERS 
    given -- String 
    
    PARAMETERS 
    ... given.toLowerCase() ...                                 -- String
   */
    
    if (this.first.toLowerCase().compareTo(given.toLowerCase()) <= 0 ) {
      return new ConsLoString(this.first, this.rest.mergeHelper(given)); }
    else { 
      return new ConsLoString(given, this.rest.mergeHelper(this.first)); }
  }   
    
  // reverses the order of the list 
  public ILoString reverse() {
    return this.rest.reverse().revert(this.first);
   
  }
    
  // to insert the given String to the end of the list
  public ILoString revert(String given) {  
    
    /*
    TEMPLATE
    FIELDS:
    ... this.first ...                                          -- String
    ... this.rest ...                                           -- ILoString
      
    METHODS
    ... this.revert(String given) ...                           -- ILoString
       
    METHODS FOR FIELDS
    ... this.first.toLowerCase() ...                            -- ILoString
    ... this.rest.mergeHelper(String) ...                       -- ILoString
    
    PARAMETERS 
    given -- String 
    
    METHODS ON PARAMETERS 
    ... given.toLowerCase() ...                                 -- String
   */
    
    return new ConsLoString(this.first, this.rest.revert(given));
   
  }
    
  // determines if this list contains pairs of identical strings, 
  public boolean isDoubledList() {
    if (this.list() % 2 == 0) {
      return this.rest.isDoubledListHelper(this.first); }
    else { 
      return false; }
  }
    
  // helper for isDoubled
  public boolean isDoubledListHelper(String given) {
    
    /*
    TEMPLATE
    FIELDS:
    ... this.first ...                                          -- String
    ... this.rest ...                                           -- ILoString
      
    METHODS
    ... this.isDoubledListHelper(String given) ...              -- ILoString
       
    METHODS FOR FIELDS
    ... this.rest.isDoubledListHelper(String) ...               -- ILoString
    
    PARAMETERS 
    given -- String 
    
   */
    
    return given.equals(this.first) && this.rest.isDoubledList();
   
  }
  
  // gets the number of strings there are in a list 
  public int list() {
    return 1 + this.rest.list();
  }
    
  // determines whether this list contains the same words reading the list in either order
  public boolean isPalindromeList() {
    return this.reverse().interleave(this).isDoubledList();
   
  }
  
}

// to represent examples for lists of strings
class ExamplesStrings {
  
  ILoString empty = new MtLoString();
  
  ILoString mary = new ConsLoString("Mary ",
      new ConsLoString("had ",
          new ConsLoString("a ",
              new ConsLoString("little ",
                  new ConsLoString("lamb.", new MtLoString())))));
  
  ILoString marySort = new ConsLoString("a ",
      new ConsLoString("had ",
          new ConsLoString("lamb.",
              new ConsLoString("little ",
                  new ConsLoString("Mary ", new MtLoString())))));
  
  ILoString abc = new ConsLoString("a",
      new ConsLoString("b",
          new ConsLoString("c",
              new ConsLoString("d",
                  new ConsLoString("e", new MtLoString())))));
  
  ILoString abcz = new ConsLoString("a",
      new ConsLoString("b",
          new ConsLoString("c",
              new ConsLoString("d",
                  new ConsLoString("e",
                      new ConsLoString("z", new MtLoString()))))));
  
  ILoString abcInterleave = new ConsLoString("a",
      new ConsLoString("Mary ",
          new ConsLoString("b",
              new ConsLoString("had ",
                  new ConsLoString("c",
                      new ConsLoString("a ",
                          new ConsLoString("d",
                              new ConsLoString("little ",
                                  new ConsLoString("e",
                                      new ConsLoString("lamb.",
                                          new MtLoString()))))))))));
  
  ILoString abcMary = new ConsLoString("a",
      new ConsLoString("a ",
          new ConsLoString("b",
              new ConsLoString("c",
                  new ConsLoString("d",
                      new ConsLoString("e",
                          new ConsLoString("had ",
                              new ConsLoString("lamb.",
                                  new ConsLoString("little ",
                                      new ConsLoString("Mary ",
                                          new MtLoString()))))))))));
  ILoString edc = new ConsLoString("e",
      new ConsLoString("d",
          new ConsLoString("c",
              new ConsLoString("b",
                  new ConsLoString("a", new MtLoString())))));
  
  ILoString aabb = new ConsLoString("a",
      new ConsLoString("a",
          new ConsLoString("b",
              new ConsLoString("b",
                  new ConsLoString("c",
                      new ConsLoString("c", new MtLoString()))))));
  
  ILoString abca = new ConsLoString("a",
      new ConsLoString("b",
          new ConsLoString("c",
              new ConsLoString("d",
                  new ConsLoString("e",
                      new ConsLoString("a", new MtLoString()))))));
  
  ILoString abb = new ConsLoString("a",
      new ConsLoString("b",
          new ConsLoString("b",
              new ConsLoString("c",
                  new ConsLoString("d",
                      new ConsLoString("e", new MtLoString()))))));
  
  ILoString aac = new ConsLoString("a",
      new ConsLoString("a",
          new ConsLoString("b",
              new ConsLoString("b",
                  new ConsLoString("c", new MtLoString())))));
  
  ILoString aca = new ConsLoString("a",
      new ConsLoString("b",
          new ConsLoString("c",
              new ConsLoString("b",
                  new ConsLoString("a", new MtLoString())))));
  
  ILoString aaa = new ConsLoString("a",
      new ConsLoString("a",
          new ConsLoString("a",
              new ConsLoString("a",
                  new ConsLoString("a", new MtLoString())))));
  
  ILoString mPalin = new ConsLoString("Mary",
      new ConsLoString("had",
          new ConsLoString("a",
              new ConsLoString("had",
                  new ConsLoString("Mary", new MtLoString())))));
  
  ILoString mPalin1 = new ConsLoString("Mary",
      new ConsLoString("had",
          new ConsLoString("a",
              new ConsLoString("a",
                  new ConsLoString("had",
                      new ConsLoString("Mary", new MtLoString()))))));
  
  ILoString aabbce = new ConsLoString("a",
      new ConsLoString("a",
          new ConsLoString("b",
              new ConsLoString("b",
                  new ConsLoString("c",
                      new ConsLoString("e", new MtLoString()))))));
  
  // test the method combine for the lists of Strings
  boolean testCombine(Tester t) {
    return t.checkExpect(this.mary.combine(), "Mary had a little lamb.")
        && t.checkExpect(this.empty.combine(), "");
   
  }
    
  // test the method sort for the lists of Strings
  boolean testSort(Tester t) {
    return t.checkExpect(this.mary.sort(), this.marySort)
        && t.checkExpect(this.empty.sort(), this.empty);
  
  }
  
  //test the method insert for the lists of Strings
  boolean testInsert(Tester t) {
    return t.checkExpect(this.abc.insert("z"), this.abcz)
        && t.checkExpect(this.empty.insert("z"), new ConsLoString("z", this.empty));
 
  }
    
  // test the method isSorted for the lists of Strings
  boolean testIsSorted(Tester t) {
    return t.checkExpect(this.mary.isSorted(), false)
        && t.checkExpect(this.marySort.isSorted(), true)
        && t.checkExpect(this.empty.isSorted(), true);
   
  }
  
  //test the method isSortHelper for the lists of Strings
  boolean testisSortedHelper(Tester t) {
    return t.checkExpect(this.mary.isSortedHelper("z"), false)
        && t.checkExpect(this.empty.isSortedHelper("z"), true);
 
  }
    
  // test the method interleave for the lists of Strings
  boolean testInterleave(Tester t) {
    return t.checkExpect(this.abc.interleave(this.mary), this.abcInterleave)
        && t.checkExpect(this.empty.interleave(this.mary), this.mary);
   
  }
    
  // test the method merge for the lists of Strings
  boolean testMerge(Tester t) {
    return t.checkExpect(this.abc.merge(this.marySort), this.abcMary)
        && t.checkExpect(this.empty.merge(this.mary), this.mary);
   
  }
  
  // test the method mergeHelper for the lists of Strings
  boolean testMergeHelper(Tester t) {
    return t.checkExpect(this.abc.mergeHelper("b"), this.abb)
        && t.checkExpect(this.empty.mergeHelper("b"), new ConsLoString("b", this.empty));
   
  }
    
  // test the method reverse for the lists of Strings
  boolean testReverse(Tester t) {
    return t.checkExpect(this.abc.reverse(), this.edc)
        && t.checkExpect(this.empty.reverse(), this.empty);
   
  }
  
  //test the method revert for the lists of Strings
  boolean testRevert(Tester t) {
    return t.checkExpect(this.abc.revert("a"), this.abca)
        && t.checkExpect(this.empty.revert("a"), new ConsLoString("a", this.empty));
  
  }
    
  // test the method isDoubledList for the lists of Strings
  boolean testIsDoubledList(Tester t) {
    return t.checkExpect(this.aabb.isDoubledList(), true)
        && t.checkExpect(this.aaa.isDoubledList(), false)
        && t.checkExpect(this.aabbce.isDoubledList(), false)
        && t.checkExpect(this.empty.isDoubledList(), true);
    
  }
  
  //test the method isDoubledListHelper for the lists of Strings
  boolean testIsDoubledListHelper(Tester t) {
    return t.checkExpect(this.aabb.isDoubledListHelper("a"), false)
        && t.checkExpect(this.empty.isDoubledListHelper("a"), false);
    
  }
  
  //test the method list for the lists of Strings
  boolean testList(Tester t) {
    return t.checkExpect(this.aabb.list(), 6)
        && t.checkExpect(this.aaa.list(), 5)
        && t.checkExpect(this.aabbce.list(), 6)
        && t.checkExpect(this.empty.list(), 0);
   
  }
    
  // test the method isPalindrome for the lists of Strings
  boolean testIsPalindromeList(Tester t) {
    return t.checkExpect(this.aca.isPalindromeList(), true)
        && t.checkExpect(this.abc.isPalindromeList(), false)
        && t.checkExpect(this.mPalin.isPalindromeList(), true)
        && t.checkExpect(this.mPalin1.isPalindromeList(), true)
        && t.checkExpect(this.empty.isPalindromeList(), true);
   
  }
  
}




