package org.example;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

  int count;
  Map<Integer, Integer> memMap ;

  public Fibonacci() {
    count=0;
    memMap = new HashMap<>();
    memMap.put(1, 1);
    memMap.put(2, 2);
  }

  public static void main(String[] args) {
    Fibonacci fib1 = new Fibonacci();
    Fibonacci fib2 = new Fibonacci();
    int n =31;
    System.out.println("fib1.fib_recurse("+n+"):" +
      fib1.fib_recurse(n) + ", count: " + fib1.count);
    System.out.println("fib2.fib_memoise("+n+"):" +
      fib2.fib_memoise(n) + ", count: " + fib2.count);
  }

  public int fib_recurse(int n) {
    count++;
    if(n <= 1) return 1;
    else {
      return fib_recurse(n-1) + fib_recurse(n-2);
    }
  }

  public int fib_memoise(int n) {
    count++;
    if(memMap.containsKey(n)) return memMap.get(n);
    else {
      int ans = fib_memoise(n-1) + fib_memoise(n-2);
      memMap.put(n, ans);
      return ans;
    }
  }

  /*
  fib1.fib_recurse(31):2178309, count: 4356617
  fib2.fib_memoise(31):2178309, count: 59
   */

}
