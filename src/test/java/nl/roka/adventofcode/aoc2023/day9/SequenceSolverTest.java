package nl.roka.adventofcode.aoc2023.day9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SequenceSolverTest {

  @Test
  @DisplayName("the next value of the first history is 18")
  void sampleSeq1() {
    var history = Sequence.parse("0 3 6 9 12 15");
    assertThat(SequenceSolver.findNext(history)).isEqualTo(18);
  }

  @Test
  @DisplayName("the next value of the second history is 28.")
  void sampleSeq2() {
    var history = Sequence.parse("1 3 6 10 15 21");
    assertThat(SequenceSolver.findNext(history)).isEqualTo(28);
  }

  @Test
  @DisplayName("the next value of the third history is 68")
  void sampleSeq3() {
    var history = Sequence.parse("10 13 16 21 30 45");
    assertThat(SequenceSolver.findNext(history)).isEqualTo(68);
  }

  @Test
  @DisplayName("the next value of the history is 2")
  void solveNegative() {
    var history = Sequence.parse("-6 -4 -2 0 2");
    assertThat(SequenceSolver.findNext(history)).isEqualTo(4);
  }
}
