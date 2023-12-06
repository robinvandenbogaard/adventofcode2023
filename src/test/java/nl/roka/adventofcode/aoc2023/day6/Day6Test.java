package nl.roka.adventofcode.aoc2023.day6;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.Answer;
import org.junit.jupiter.api.Test;

class Day6Test {

  @Test
  void runSilver() {
    assertThat(new Day6().runSilver()).isEqualTo(Answer.of("288"));
  }

  @Test
  void runGold() {
    assertThat(new Day6().runGold()).isEqualTo(Answer.of("TBD"));
  }
}
