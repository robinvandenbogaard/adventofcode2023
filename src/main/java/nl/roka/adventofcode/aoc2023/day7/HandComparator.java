package nl.roka.adventofcode.aoc2023.day7;

import java.util.Comparator;

public class HandComparator {
  public static int compare(Hand hand, Hand other) {
    int strenghtComparison = Comparator.comparingInt(Hand::strength).compare(hand, other);
    if (strenghtComparison == 0) {
      return HighCardComparator.compare(hand, other);
    } else {
      return strenghtComparison;
    }
  }
}
