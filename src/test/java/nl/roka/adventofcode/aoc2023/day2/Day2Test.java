package nl.roka.adventofcode.aoc2023.day2;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.Answer;
import nl.roka.adventofcode.aoc.LineReader;
import org.junit.jupiter.api.Test;

class Day2Test {

  @Test
  void silverExample() {
    assertThat(new Day2().runSilver()).isEqualTo(Answer.of("TBD"));
  }

  @Test
  void goldExample() {
    assertThat(new Day2(LineReader.of("/day2-gold.in")).runGold()).isEqualTo(Answer.of("TBD"));
  }
}
