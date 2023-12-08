package nl.roka.adventofcode.aoc2023.day7;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardTypeTest {

  @Test
  void fiveOfAKind() {
    assertThat(CardType.of("55555")).isEqualTo(CardType.FiveOfKind);
  }

  @Test
  void fiveOfAKind_Joker() {
    assertThat(CardType.ofJoker("JJJJJ")).isEqualTo(CardType.FiveOfKind);
    assertThat(CardType.ofJoker("JJ555")).isEqualTo(CardType.FiveOfKind);
    assertThat(CardType.ofJoker("JJJ55")).isEqualTo(CardType.FiveOfKind);
    assertThat(CardType.ofJoker("JJJJ5")).isEqualTo(CardType.FiveOfKind);
    assertThat(CardType.ofJoker("J5555")).isEqualTo(CardType.FiveOfKind);
    assertThat(CardType.ofJoker("5J555")).isEqualTo(CardType.FiveOfKind);
    assertThat(CardType.ofJoker("55J55")).isEqualTo(CardType.FiveOfKind);
    assertThat(CardType.ofJoker("555J5")).isEqualTo(CardType.FiveOfKind);
    assertThat(CardType.ofJoker("5555J")).isEqualTo(CardType.FiveOfKind);
  }

  @Test
  void fourOfKind() {
    assertThat(CardType.of("J4444")).isEqualTo(CardType.FourOfKind);
  }

  @Test
  void fourOfKind_Joker() {
    assertThat(CardType.ofJoker("#J444")).isEqualTo(CardType.FourOfKind);
    assertThat(CardType.ofJoker("#JJJ4")).isEqualTo(CardType.FourOfKind);
    assertThat(CardType.ofJoker("$JJ**")).isEqualTo(CardType.FourOfKind);
  }

  @Test
  void fullHouse() {
    assertThat(CardType.of("JJ***")).isEqualTo(CardType.FullHouse);
  }

  @Test
  void threeOfKind() {
    assertThat(CardType.of("AJ333")).isEqualTo(CardType.ThreeOfKind);
  }

  @Test
  void threeOfKind_Joker() {
    assertThat(CardType.ofJoker("AB3JJ")).isEqualTo(CardType.ThreeOfKind);
  }

  @Test
  void twoPair() {
    assertThat(CardType.of("AA##J")).isEqualTo(CardType.TwoPair);
  }

  @Test
  void onePair() {
    assertThat(CardType.of("KKJHT")).isEqualTo(CardType.OnePair);
  }

  @Test
  void onePair_Joker() {
    assertThat(CardType.ofJoker("KJYHT")).isEqualTo(CardType.OnePair);
  }

  @Test
  void highCard() {
    assertThat(CardType.of("12345")).isEqualTo(CardType.HighCard);
  }

  @Test
  void failingInput1() {
    assertThat(CardType.of("33773")).isEqualTo(CardType.FullHouse);
  }

  @Test
  @DisplayName("T55J5, KTJJT, and QQQJA are now all four of a kind")
  void jokerExampleTest() {
    assertThat(CardType.ofJoker("T55J5")).isEqualTo(CardType.FourOfKind);
    assertThat(CardType.ofJoker("KTJJT")).isEqualTo(CardType.FourOfKind);
    assertThat(CardType.ofJoker("QQQJA")).isEqualTo(CardType.FourOfKind);
  }
}
