package org.example;

import java.util.Arrays;

/**
 * This implements the famous Towers of Hanoi using a recursive function.
 * <br />
 * You start with three towers.
 * Only one tower has items, and these are in ascending order by size.
 * The other towers are empty at the start.
 * The goal is to move all items onto the next tower retaining the same order.
 * <br />
 * The following rules apply.
 * 1. You may only move one item at a time.
 * 2. You may not put a larger item on top of a smaller item.
 */

public class TowersOfHanoi {

  public static final int TOWER_FROM = 0;
  public static final int TOWER_TO = 1;
  public static final int TOWER_SPARE = 2;
  String[][] towers;
  int steps = 0;

  public static void main(String[] args) {
    String[][] towers = {
      {"AAAAAA", "BBBBB", "CCCC", "DDD", "EE", "F"},
      {},
      {}
    };

    TowersOfHanoi toh = new TowersOfHanoi(towers);
    toh.printTowers();
    toh.moveFromToTo(towers[TOWER_FROM].length, TOWER_FROM, TOWER_TO, TOWER_SPARE);
  }

  public TowersOfHanoi(String[][] towers){
    this.towers = towers;
  }

  public void moveFromToTo(int n, int from, int to, int spare) {
    if (n == 1) {
      move(n, from, to);
    } else {
      moveFromToTo(n - 1, from, spare, to);
      moveFromToTo(1, from, to, spare);
      moveFromToTo(n - 1, spare, to, from);
    }
  }

  private void move(int n, int from, int to) {
    steps++;
    String item = towers[from][towers[from].length - 1];
    towers[from] = removeOne(towers[from]);
    towers[to] = addOne(towers[to], item);
    printTowers();
  }

  private String[] removeOne(String[] from) {
    String[] out = new String[from.length - 1];
    System.arraycopy(from, 0, out, 0, from.length - 1);
    return out;
  }

  private String[] addOne(String[] from, String item) {
    String[] out = new String[from.length + 1];
    System.arraycopy(from, 0, out, 0, from.length);
    out[out.length - 1] = item;
    return out;
  }

  private void printTowers() {
    StringBuilder buf = new StringBuilder();
    buf.append(String.format("%2d ", steps));
    for (String[] tower : towers) {
      buf.append(Arrays.asList(tower));
      buf.append(" ");
    }
    System.out.println(buf);
  }

  /*
     0 [AAAAAA, BBBBB, CCCC, DDD, EE, F] [] []
     1 [AAAAAA, BBBBB, CCCC, DDD, EE] [] [F]
     2 [AAAAAA, BBBBB, CCCC, DDD] [EE] [F]
     3 [AAAAAA, BBBBB, CCCC, DDD] [EE, F] []
     4 [AAAAAA, BBBBB, CCCC] [EE, F] [DDD]
     5 [AAAAAA, BBBBB, CCCC, F] [EE] [DDD]
     6 [AAAAAA, BBBBB, CCCC, F] [] [DDD, EE]
     7 [AAAAAA, BBBBB, CCCC] [] [DDD, EE, F]
     8 [AAAAAA, BBBBB] [CCCC] [DDD, EE, F]
     9 [AAAAAA, BBBBB] [CCCC, F] [DDD, EE]
    10 [AAAAAA, BBBBB, EE] [CCCC, F] [DDD]
    11 [AAAAAA, BBBBB, EE, F] [CCCC] [DDD]
    12 [AAAAAA, BBBBB, EE, F] [CCCC, DDD] []
    13 [AAAAAA, BBBBB, EE] [CCCC, DDD] [F]
    14 [AAAAAA, BBBBB] [CCCC, DDD, EE] [F]
    15 [AAAAAA, BBBBB] [CCCC, DDD, EE, F] []
    16 [AAAAAA] [CCCC, DDD, EE, F] [BBBBB]
    17 [AAAAAA, F] [CCCC, DDD, EE] [BBBBB]
    18 [AAAAAA, F] [CCCC, DDD] [BBBBB, EE]
    19 [AAAAAA] [CCCC, DDD] [BBBBB, EE, F]
    20 [AAAAAA, DDD] [CCCC] [BBBBB, EE, F]
    21 [AAAAAA, DDD] [CCCC, F] [BBBBB, EE]
    22 [AAAAAA, DDD, EE] [CCCC, F] [BBBBB]
    23 [AAAAAA, DDD, EE, F] [CCCC] [BBBBB]
    24 [AAAAAA, DDD, EE, F] [] [BBBBB, CCCC]
    25 [AAAAAA, DDD, EE] [] [BBBBB, CCCC, F]
    26 [AAAAAA, DDD] [EE] [BBBBB, CCCC, F]
    27 [AAAAAA, DDD] [EE, F] [BBBBB, CCCC]
    28 [AAAAAA] [EE, F] [BBBBB, CCCC, DDD]
    29 [AAAAAA, F] [EE] [BBBBB, CCCC, DDD]
    30 [AAAAAA, F] [] [BBBBB, CCCC, DDD, EE]
    31 [AAAAAA] [] [BBBBB, CCCC, DDD, EE, F]
    32 [] [AAAAAA] [BBBBB, CCCC, DDD, EE, F]
    33 [] [AAAAAA, F] [BBBBB, CCCC, DDD, EE]
    34 [EE] [AAAAAA, F] [BBBBB, CCCC, DDD]
    35 [EE, F] [AAAAAA] [BBBBB, CCCC, DDD]
    36 [EE, F] [AAAAAA, DDD] [BBBBB, CCCC]
    37 [EE] [AAAAAA, DDD] [BBBBB, CCCC, F]
    38 [] [AAAAAA, DDD, EE] [BBBBB, CCCC, F]
    39 [] [AAAAAA, DDD, EE, F] [BBBBB, CCCC]
    40 [CCCC] [AAAAAA, DDD, EE, F] [BBBBB]
    41 [CCCC, F] [AAAAAA, DDD, EE] [BBBBB]
    42 [CCCC, F] [AAAAAA, DDD] [BBBBB, EE]
    43 [CCCC] [AAAAAA, DDD] [BBBBB, EE, F]
    44 [CCCC, DDD] [AAAAAA] [BBBBB, EE, F]
    45 [CCCC, DDD] [AAAAAA, F] [BBBBB, EE]
    46 [CCCC, DDD, EE] [AAAAAA, F] [BBBBB]
    47 [CCCC, DDD, EE, F] [AAAAAA] [BBBBB]
    48 [CCCC, DDD, EE, F] [AAAAAA, BBBBB] []
    49 [CCCC, DDD, EE] [AAAAAA, BBBBB] [F]
    50 [CCCC, DDD] [AAAAAA, BBBBB, EE] [F]
    51 [CCCC, DDD] [AAAAAA, BBBBB, EE, F] []
    52 [CCCC] [AAAAAA, BBBBB, EE, F] [DDD]
    53 [CCCC, F] [AAAAAA, BBBBB, EE] [DDD]
    54 [CCCC, F] [AAAAAA, BBBBB] [DDD, EE]
    55 [CCCC] [AAAAAA, BBBBB] [DDD, EE, F]
    56 [] [AAAAAA, BBBBB, CCCC] [DDD, EE, F]
    57 [] [AAAAAA, BBBBB, CCCC, F] [DDD, EE]
    58 [EE] [AAAAAA, BBBBB, CCCC, F] [DDD]
    59 [EE, F] [AAAAAA, BBBBB, CCCC] [DDD]
    60 [EE, F] [AAAAAA, BBBBB, CCCC, DDD] []
    61 [EE] [AAAAAA, BBBBB, CCCC, DDD] [F]
    62 [] [AAAAAA, BBBBB, CCCC, DDD, EE] [F]
    63 [] [AAAAAA, BBBBB, CCCC, DDD, EE, F] []
   */

}