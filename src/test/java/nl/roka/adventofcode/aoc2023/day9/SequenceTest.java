package nl.roka.adventofcode.aoc2023.day9;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class SequenceTest {

  @Test
  void parse() {
    assertThat(Sequence.parse("1 2 3 4 5 6").values())
        .containsExactly(
            BigInteger.valueOf(1),
            BigInteger.valueOf(2),
            BigInteger.valueOf(3),
            BigInteger.valueOf(4),
            BigInteger.valueOf(5),
            BigInteger.valueOf(6));
  }

  @Test
  void parseNegative() {
    assertThat(Sequence.parse("1 -2 3 -4 5 6").values())
        .containsExactly(
            BigInteger.valueOf(1),
            BigInteger.valueOf(-2),
            BigInteger.valueOf(3),
            BigInteger.valueOf(-4),
            BigInteger.valueOf(5),
            BigInteger.valueOf(6));
  }

  @Test
  void same() {
    assertThat(Sequence.parse("1 1 1 1").valuesAreEqual()).isTrue();
    assertThat(Sequence.parse("1 2 1 1").valuesAreEqual()).isFalse();
  }

  @Test
  void diff() {
    assertThat(Sequence.parse("16 18").diff(0, 1)).isEqualTo(BigInteger.valueOf(2));
  }

  @Test
  void negativeDiffIsAllowed() {
    assertThat(Sequence.parse("18 16").diff(0, 1)).isEqualTo(BigInteger.valueOf(-2));
  }
}
