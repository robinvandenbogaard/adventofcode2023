package nl.roka.adventofcode.aoc2023.day5;

import java.math.BigInteger;

public record Seed(BigInteger number) {
  public static Seed of(long nr) {
    return new Seed(BigInteger.valueOf(nr));
  }
}
