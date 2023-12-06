package nl.roka.adventofcode.aoc2023.day6;

import java.math.BigInteger;

public record Speed(BigInteger millis) {
  public Speed add(BigInteger millis) {
    return new Speed(this.millis.add(millis));
  }
}
