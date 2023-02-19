package com.leeq.neu.construct;

class Date {
  int year;
  int month;
  int day;
  
  Date(int year, int month, int day) {
    
    Utils utils = new Utils();
    
    
//    if(year >= 1500 && year <= 2100) {
//      this.year = year;
//    }
//    else {
//      throw new IllegalArgumentException("Invalid year: " + Integer.toString(year));
//    }
    utils.checkRange(year, 1500, 2100, "Invalid year: " + Integer.toString(year));
    
    if(month >= 1 && month <= 12) {
      this.month = month;
    }
    else {
      throw new IllegalArgumentException("Invalid month: " + Integer.toString(month));
    }
    
    if(day >= 1 && day <= 31) {
      this.day = day;
    }
    else {
      throw new IllegalArgumentException("Invalid day: " + Integer.toString(day));
    }
  }
}

class Utils {
  int checkRange(int val, int min, int max, String msg) {
    if (val >= min && val <= max) {
      return val;
    }
    else {
      throw new IllegalArgumentException(msg);
    }
  }
}
