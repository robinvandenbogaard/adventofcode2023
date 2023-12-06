package nl.roka.adventofcode.aoc2023.day6;

import java.math.BigInteger;

public record Distance(BigInteger millimeters) {
  public static Distance ofMillimeters(BigInteger distanceInMillis) {
    return new Distance(distanceInMillis);
  }

  public static Distance ofMillimeters(int distanceInMillis) {
    return new Distance(BigInteger.valueOf(distanceInMillis));
  }
}
