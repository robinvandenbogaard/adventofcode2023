package nl.roka.adventofcode.aoc2023.day7;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HandTest {

  @Test
  void parse() {
    assertThat(Hand.parse("JJJJJ 123"))
        .isEqualTo(new Hand("JJJJJ", Bid.of("123"), CardType.FiveOfKind));
  }

  @Test
  void ranked() {
    assertThat(new Hand(null, Bid.of("123"), null).ranked(5))
        .isEqualTo(new RankedHand(Bid.of("123"), 5));
  }
}
