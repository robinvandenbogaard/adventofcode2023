package nl.roka.adventofcode.aoc2023.day7;

public record Hand(String hand, Bid bid, CardType cardType) {
  public static Hand parse(String line) {
    String[] split = line.split(" ");
    String hand = split[0];
    return new Hand(hand, Bid.of(split[1]), CardType.of(hand));
  }

  public RankedHand ranked(int position) {
    return new RankedHand(bid, position);
  }

  public int strength() {
    return cardType.strength();
  }
}
