package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Palindrome {

  public static void main(String[] args) {
    Palindrome pal = new Palindrome();
    pal.testPal("A");
    pal.testPal("AA");
    pal.testPal("AB");
    pal.testPal("mam");
    pal.testPal("Man");
    pal.testPal("Abba");
    pal.testPal("racecar");
    pal.testPal("Madam, I'm Adam");
    pal.testPal("A Man, A Plan, A Canal, Panama");
    pal.testPal("A Man, A Plan, Git A Canal, Panama");
  }

  public void testPal(String input) {
    String s = toChars(input);
    boolean b1 = isPal_recursive(s);
    boolean b2 = isPal_looping(s);
    System.out.println("'" + input +
      "', isPalendrome: " +
      "(1): " + b1 +
      ", (2): " + b2 +
      ", same = " + (b1 == b2));
  }

  public boolean isPal_recursive(String s) {
    if(s.length() <= 1){
      return true;
    } else {
      return (s.charAt(0) == s.charAt(s.length() - 1)) &&
        isPal_recursive(s.substring(1, s.length() - 1));
    }
  }

  public boolean isPal_looping(String s) {
    for(int i = 0; i < s.length(); i++){
      if(s.charAt(i) != s.charAt(s.length()-i-1)){
        return false;
      }
    }
    return true;
  }

  public String toChars(String input) {
    String s = input.toLowerCase();
    StringBuilder ans = new StringBuilder();
    for(char c: s.toCharArray()){
      if(Character.isLetter(c)){
        ans.append(c);
      }
    }
    return ans.toString();
  }

  /*
    'A', isPalendrome: (1): true, (2): true, same = true
    'AA', isPalendrome: (1): true, (2): true, same = true
    'AB', isPalendrome: (1): false, (2): false, same = true
    'mam', isPalendrome: (1): true, (2): true, same = true
    'Man', isPalendrome: (1): false, (2): false, same = true
    'Abba', isPalendrome: (1): true, (2): true, same = true
    'racecar', isPalendrome: (1): true, (2): true, same = true
    'Madam, I'm Adam', isPalendrome: (1): true, (2): true, same = true
    'A Man, A Plan, A Canal, Panama', isPalendrome: (1): true, (2): true, same = true
    'A Man, A Plan, Git A Canal, Panama', isPalendrome: (1): false, (2): false, same = true
   */
}
