package nl.roka.adventofcode.aoc2023.day5;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class MappingTest {
  @Test
  void destination() {
    var mapping = Mapping.of(10, 100, 10);
    assertThat(mapping.getDestination(BigInteger.valueOf(100))).isEqualTo(BigInteger.valueOf(10));
    assertThat(mapping.getDestination(BigInteger.valueOf(101))).isEqualTo(BigInteger.valueOf(11));
    assertThat(mapping.getDestination(BigInteger.valueOf(102))).isEqualTo(BigInteger.valueOf(12));
    assertThat(mapping.getDestination(BigInteger.valueOf(103))).isEqualTo(BigInteger.valueOf(13));
    assertThat(mapping.getDestination(BigInteger.valueOf(104))).isEqualTo(BigInteger.valueOf(14));
    assertThat(mapping.getDestination(BigInteger.valueOf(105))).isEqualTo(BigInteger.valueOf(15));
    assertThat(mapping.getDestination(BigInteger.valueOf(106))).isEqualTo(BigInteger.valueOf(16));
    assertThat(mapping.getDestination(BigInteger.valueOf(107))).isEqualTo(BigInteger.valueOf(17));
    assertThat(mapping.getDestination(BigInteger.valueOf(108))).isEqualTo(BigInteger.valueOf(18));
    assertThat(mapping.getDestination(BigInteger.valueOf(109))).isEqualTo(BigInteger.valueOf(19));
  }

  @Test
  void between() {
    var mapping = Mapping.of(10, 100, 2);
    assertThat(mapping.inRange(BigInteger.valueOf(99))).isFalse();
    assertThat(mapping.inRange(BigInteger.valueOf(100))).isTrue();
    assertThat(mapping.inRange(BigInteger.valueOf(101))).isTrue();
    assertThat(mapping.inRange(BigInteger.valueOf(102))).isFalse();
  }
}
