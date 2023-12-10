package nl.roka.adventofcode.aoc2023.day9;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SequenceTest {

  @Test
  void parse() {
    assertThat(Sequence.parse("1 2 3 4 5 6").values()).containsExactly(1L, 2L, 3L, 4L, 5L, 6L);
  }

  @Test
  void same() {
    assertThat(Sequence.parse("1 1 1 1").valuesAreEqual()).isTrue();
    assertThat(Sequence.parse("1 2 1 1").valuesAreEqual()).isFalse();
  }
}
