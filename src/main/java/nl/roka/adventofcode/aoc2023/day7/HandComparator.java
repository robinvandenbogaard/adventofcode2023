package nl.roka.adventofcode.aoc2023.day7;

import java.util.Comparator;
import java.util.function.BiFunction;

public class HandComparator {
  public static int compare(Hand hand, Hand other) {
    return doSpecializedCompare(hand, other, HighCardComparator::compare);
  }

  public static int compareWithJoker(Hand hand, Hand other) {
    return doSpecializedCompare(hand, other, HighCardComparator::compareJoker);
  }

  private static int doSpecializedCompare(
      Hand hand, Hand other, BiFunction<Hand, Hand, Integer> comparison) {
    int strenghtComparison = Comparator.comparingInt(Hand::strength).compare(hand, other);
    if (strenghtComparison == 0) {
      return comparison.apply(hand, other);
    } else {
      return strenghtComparison;
    }
  }
}
