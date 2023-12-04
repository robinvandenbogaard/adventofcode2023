package nl.roka.adventofcode.aoc2023.day4;

public class ScoreCalculator {
  public static long score(long matches) {
    if (matches > 1) {
      return (long) Math.pow(2, matches - 1);
    } else {
      return matches;
    }
  }
}
