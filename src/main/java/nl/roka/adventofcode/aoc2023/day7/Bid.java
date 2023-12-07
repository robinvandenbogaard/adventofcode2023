package nl.roka.adventofcode.aoc2023.day7;

import java.math.BigInteger;

public record Bid(BigInteger value) {
  public static Bid of(String bid) {
    return new Bid(new BigInteger(bid));
  }
}
