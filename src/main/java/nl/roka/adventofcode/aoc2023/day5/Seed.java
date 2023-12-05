package nl.roka.adventofcode.aoc2023.day5;

import java.math.BigInteger;

public record Seed(BigInteger number, BigInteger length) {

  public static Seed of(long nr) {
    return new Seed(BigInteger.valueOf(nr), BigInteger.ZERO);
  }

  public static Seed of(BigInteger nr) {
    return new Seed(nr, BigInteger.ZERO);
  }
}
