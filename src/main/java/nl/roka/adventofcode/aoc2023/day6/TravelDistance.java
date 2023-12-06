package nl.roka.adventofcode.aoc2023.day6;

import java.math.BigInteger;

public record TravelDistance(BigInteger distance) {
  public boolean greaterThan(Distance distance) {
    return this.distance.compareTo(distance.millimeters()) > 0;
  }
}
