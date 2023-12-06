package nl.roka.adventofcode.aoc2023.day6;

import java.math.BigInteger;

public record Race(BigInteger timeInMs, Distance distance) {
  public static Race of(BigInteger timeInMs, BigInteger distanceInMilis) {
    return new Race(timeInMs, Distance.ofMillimeters(distanceInMilis));
  }

  public static Race of(int timeInMs, int distanceInMilis) {
    return new Race(BigInteger.valueOf(timeInMs), Distance.ofMillimeters(distanceInMilis));
  }

  public int numberOfWaysToWin() {
    var boat = new Boat();
    var wins = 0;
    for (BigInteger i = BigInteger.ZERO; i.compareTo(timeInMs) < 0; i = i.add(BigInteger.ONE)) {
      if (boat.holdButtonFor(i).release(timeInMs).greaterThan(distance)) {
        wins++;
      }
    }
    return wins;
  }
}
