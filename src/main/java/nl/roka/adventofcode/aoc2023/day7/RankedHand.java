package nl.roka.adventofcode.aoc2023.day7;

import java.math.BigInteger;

public record RankedHand(Bid bid, int rank) {
  public int score() {
    return bid.value().multiply(BigInteger.valueOf(rank)).intValue();
  }
}
