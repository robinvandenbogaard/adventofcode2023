package nl.roka.adventofcode.aoc2023.day8;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import nl.roka.adventofcode.aoc.puzzle.Answer;
import org.junit.jupiter.api.Test;

class Day8Test {

  @Test
  void runSilver() {
    assertThat(new Day8().runSilver()).isEqualTo(Answer.of(6));
  }

  @Test
  void runGold() {
    assertThat(new Day8().runGold()).isEqualTo(Answer.TBD);
  }
}
