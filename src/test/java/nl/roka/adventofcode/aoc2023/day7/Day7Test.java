package nl.roka.adventofcode.aoc2023.day7;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.puzzle.Answer;
import org.junit.jupiter.api.Test;

class Day7Test {

  @Test
  void runSilver() {
    assertThat(new Day7().runSilver()).isEqualTo(Answer.of("6440"));
  }

  @Test
  void runGold() {
    assertThat(new Day7().runGold()).isEqualTo(Answer.of("5905"));
  }
}
