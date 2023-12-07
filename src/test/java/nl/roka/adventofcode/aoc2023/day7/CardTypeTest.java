package nl.roka.adventofcode.aoc2023.day7;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CardTypeTest {

  @Test
  void fiveOfAKind() {
    assertThat(CardType.of("55555")).isEqualTo(CardType.FiveOfKind);
  }

  @Test
  void fourOfKind() {
    assertThat(CardType.of("#4444")).isEqualTo(CardType.FourOfKind);
  }

  @Test
  void fullHouse() {
    assertThat(CardType.of("$$***")).isEqualTo(CardType.FullHouse);
  }

  @Test
  void threeOfKind() {
    assertThat(CardType.of("AB333")).isEqualTo(CardType.ThreeOfKind);
  }

  @Test
  void twoPair() {
    assertThat(CardType.of("A#A#7")).isEqualTo(CardType.TwoPair);
  }

  @Test
  void onePair() {
    assertThat(CardType.of("KYHJK")).isEqualTo(CardType.OnePair);
  }

  @Test
  void highCard() {
    assertThat(CardType.of("12345")).isEqualTo(CardType.HighCard);
  }
}
