package nl.roka.adventofcode.aoc2023.day7;

import java.util.Arrays;

public enum CardType {
  FiveOfKind(7),
  FourOfKind(6),
  FullHouse(5),
  ThreeOfKind(4),
  TwoPair(3),
  OnePair(2),
  HighCard(1);

  private final int strength;

  CardType(int strength) {
    this.strength = strength;
  }

  public static CardType of(String hand) {
    var cards = hand.toCharArray();
    Arrays.sort(cards);

    var uniqueCount = 1;
    var sequenceCount = 1;
    var pairs = 0;
    char previousChar = cards[0];
    for (int i = 1; i < 5; i++) {
      var currentChar = cards[i];
      if (currentChar != previousChar) {
        uniqueCount++;
        if (sequenceCount == 2) pairs++;
        sequenceCount = 1;
      } else {
        sequenceCount++;
      }
      previousChar = currentChar;
    }

    if (uniqueCount == 1) return FiveOfKind;
    else if (uniqueCount == 2 && (sequenceCount == 1 || sequenceCount == 4)) return FourOfKind;
    else if (uniqueCount == 2 && (sequenceCount == 2 || sequenceCount == 3)) return FullHouse;
    else if (uniqueCount == 3 && pairs > 0) return TwoPair;
    else if (uniqueCount == 3) return CardType.ThreeOfKind;
    else if (uniqueCount == 4) return OnePair;
    else if (uniqueCount == 5) return HighCard;

    throw new IllegalArgumentException("Unknown card type for hand '" + hand + "'");
  }

  public static CardType ofJoker(String hand) {
    var regular = of(hand);
    if (!hand.contains("J")) return regular;

    return switch (regular) {
      case FiveOfKind -> regular;
      case FourOfKind, FullHouse -> FiveOfKind;
      case ThreeOfKind, TwoPair -> FourOfKind;
      case OnePair -> ThreeOfKind;
      case HighCard -> OnePair;
    };
  }

  public int strength() {
    return strength;
  }
}
