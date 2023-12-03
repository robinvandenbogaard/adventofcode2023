package nl.roka.adventofcode.aoc2023.day3;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.Answer;
import org.junit.jupiter.api.Test;

class Day3Test {

  @Test
  void silverExample() {
    assertThat(new Day3().runSilver()).isEqualTo(Answer.of("4361"));
  }

  @Test
  void goldExample() {
    assertThat(new Day3().runGold()).isEqualTo(Answer.of("TBD"));
  }
}
