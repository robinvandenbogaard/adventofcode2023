package nl.roka.adventofcode.aoc2023.day7;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HighCardComparatorTest {

  @ParameterizedTest
  @CsvSource({"2AAAA,AAAAA", "A2AAA,AAAAA", "AA2AA,AAAAA", "AAA2A,AAAAA", "AAAA2,AAAAA"})
  void compare(String lowHand, String highHand) {
    var lower = new Hand(lowHand, null, null);
    var higher = new Hand(highHand, null, null);
    assertThat(HighCardComparator.compare(lower, higher)).isEqualTo(-1);
    assertThat(HighCardComparator.compare(higher, lower)).isEqualTo(1);
  }

  @Test
  void compare() {
    var lower = new Hand("AAAAA", null, null);
    var higher = new Hand("AAAAA", null, null);
    assertThat(HighCardComparator.compare(lower, higher)).isEqualTo(0);
    assertThat(HighCardComparator.compare(higher, lower)).isEqualTo(0);
  }
}
