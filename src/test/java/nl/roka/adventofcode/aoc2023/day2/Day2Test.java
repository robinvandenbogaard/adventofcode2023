package nl.roka.adventofcode.aoc2023.day2;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.Answer;
import org.junit.jupiter.api.Test;

class Day2Test {

  @Test
  void silverExample() {
    assertThat(new Day2().runSilver()).isEqualTo(Answer.of("8"));
  }

  @Test
  void goldExample() {
    assertThat(new Day2().runGold()).isEqualTo(Answer.of("2286"));
  }
}
