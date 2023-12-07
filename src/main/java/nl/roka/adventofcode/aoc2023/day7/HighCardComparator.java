package nl.roka.adventofcode.aoc2023.day7;

import java.util.HashMap;

public class HighCardComparator {

  private static final HashMap<Character, Integer> SCORE_MAP;

  static {
    SCORE_MAP = new HashMap<>();
    SCORE_MAP.put('A', 12);
    SCORE_MAP.put('K', 11);
    SCORE_MAP.put('Q', 10);
    SCORE_MAP.put('J', 9);
    SCORE_MAP.put('T', 8);
    SCORE_MAP.put('9', 7);
    SCORE_MAP.put('8', 6);
    SCORE_MAP.put('7', 5);
    SCORE_MAP.put('6', 4);
    SCORE_MAP.put('5', 3);
    SCORE_MAP.put('4', 2);
    SCORE_MAP.put('3', 1);
    SCORE_MAP.put('2', 0);
  }

  public static int compare(Hand hand, Hand other) {
    var a = hand.hand();
    var b = other.hand();
    var result = 0;
    for (int index = 0; index < a.length() && result == 0; index++) {
      var score_a = SCORE_MAP.get(a.charAt(index));
      var score_b = SCORE_MAP.get(b.charAt(index));
      result = score_a.compareTo(score_b);
    }

    return result;
  }
}
