package nl.roka.adventofcode.aoc2023.day5;

import java.math.BigInteger;

record Mapping(BigInteger destinationRange, BigInteger sourceRange, BigInteger length) {

  public static Mapping of(long destinationRange, long sourceRange, long length) {
    return new Mapping(
        BigInteger.valueOf(destinationRange),
        BigInteger.valueOf(sourceRange),
        BigInteger.valueOf(length));
  }

  public boolean inRange(BigInteger source) {
    return between(sourceRange, sourceRange.add(length.subtract(BigInteger.ONE)), source);
  }

  private boolean between(BigInteger min, BigInteger max, BigInteger target) {
    return target.compareTo(min) >= 0 && target.compareTo(max) <= 0;
  }

  public BigInteger getDestination(BigInteger source) {
    return destinationRange.add(source.subtract(sourceRange));
  }
}
