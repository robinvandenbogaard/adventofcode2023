package nl.roka.adventofcode.aoc2023.day5;

import java.math.BigInteger;

public record Mapping(BigInteger destinationRange, BigInteger sourceRange, BigInteger length) {

  public static Mapping of(long destinationRange, long sourceRange, long length) {
    return new Mapping(
        BigInteger.valueOf(destinationRange),
        BigInteger.valueOf(sourceRange),
        BigInteger.valueOf(length));
  }
}
