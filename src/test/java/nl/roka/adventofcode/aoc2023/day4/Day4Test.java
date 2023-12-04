package nl.roka.adventofcode.aoc2023.day4;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.Answer;
import org.junit.jupiter.api.Test;

class Day4Test {

  @Test
  void runSilver() {
    assertThat(new Day4().runSilver()).isEqualTo(Answer.of("13"));
  }

  @Test
  void runGold() {
    assertThat(new Day4().runGold()).isEqualTo(Answer.of("30"));
  }
}
