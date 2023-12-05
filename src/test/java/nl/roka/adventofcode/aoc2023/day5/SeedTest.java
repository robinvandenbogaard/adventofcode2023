package nl.roka.adventofcode.aoc2023.day5;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

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
}
