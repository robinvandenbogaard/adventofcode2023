package nl.roka.adventofcode.aoc2023.day3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SymbolTest {
  @Test
  void isGear() {
    var symbol = Symbol.of(1, 1, "*");
    assertThat(symbol.isGear()).isTrue();
  }

  @Test
  void isNotGear() {
    var symbol = Symbol.of(1, 1, "#");
    assertThat(symbol.isGear()).isFalse();
  }
}
