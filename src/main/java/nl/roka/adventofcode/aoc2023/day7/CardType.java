package nl.roka.adventofcode.aoc2023.day7;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum CardType {
  FiveOfKind(7),
  FourOfKind(6),
  FullHouse(5),
  ThreeOfKind(4),
  TwoPair(3),
  OnePair(2),
  HighCard(1);

  private static final Logger log = LoggerFactory.getLogger(CardType.class);

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

    var result =
        switch (regular) {
          case FiveOfKind -> regular;
          case FourOfKind, FullHouse -> FiveOfKind;
          case ThreeOfKind -> FourOfKind;
          case TwoPair -> hasTwoJokers(hand) ? FourOfKind : FullHouse;
          case OnePair -> ThreeOfKind;
          case HighCard -> OnePair;
        };

    log.debug("Hand '{}' = '{}'.", hand, result);

    return result;
  }

  private static boolean hasTwoJokers(String hand) {
    var cards = hand.toCharArray();
    Arrays.sort(cards);
    return new String(cards).contains("JJ");
  }

  public int strength() {
    return strength;
  }
}
