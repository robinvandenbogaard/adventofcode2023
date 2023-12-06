package nl.roka.adventofcode.aoc2023.day5;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SeedTest {
  @Test
  void forEachSingle() {
    var result = new ArrayList<Seed>();
    Seed.of(1).forEach(result::add);

    assertThat(result).containsExactly(Seed.of(1));
  }

  @Test
  void forEachDouble() {
    var result = new ArrayList<Seed>();
    new Seed(BigInteger.ONE, BigInteger.TWO).forEach(result::add);

    assertThat(result).containsExactly(Seed.of(1), Seed.of(2));
  }

  @Test
  void hasOverlap() {
    var a = new Seed(10, 10);
    var b = new Seed(5, 6);

    assertThat(a.hasOverlap(b)).isTrue();
    assertThat(b.hasOverlap(a)).isTrue();
  }

  @Test
  void hasNoOverlap() {
    var a = new Seed(100, 10);
    var b = new Seed(5, 5);

    assertThat(a.hasOverlap(b)).isFalse();
    assertThat(b.hasOverlap(a)).isFalse();
  }

  @Test
  void minValue() {
    assertThat(new Seed(100, 10).minValue()).isEqualTo(new BigInteger("100"));
  }

  @Test
  void maxValue() {
    assertThat(new Seed(100, 10).maxValue()).isEqualTo(new BigInteger("109"));
  }

  @ParameterizedTest
  @CsvSource({"100", "101", "102"})
  void isBetween(BigInteger value) {
    var a = new Seed(100, 3);

    assertThat(a.between(value, a)).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"99", "103"})
  void isNotBetween(BigInteger value) {
    var a = new Seed(100, 3);

    assertThat(a.between(value, a)).isFalse();
  }

  @Test
  void merge() {
    var a = new Seed(10, 10); // 10-19
    var b = new Seed(5, 6); // 5-10

    assertThat(a.merge(b)).isEqualTo(new Seed(5, 14)); // 5-19
    assertThat(b.merge(a)).isEqualTo(new Seed(5, 14)); // 5-19
  }
}
