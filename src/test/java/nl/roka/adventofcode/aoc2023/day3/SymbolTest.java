package nl.roka.adventofcode.aoc2023.day3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import nl.roka.adventofcode.aoc.Point;
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

  @Test
  void productOnlyAllowedForGears() {
    var symbol = Symbol.of(1, 1, "#");
    assertThatThrownBy(symbol::productOfParts);
  }

  @Test
  void productZeroPartsIsZero() {
    var symbol = Symbol.of(1, 1, "*");
    assertThat(symbol.productOfParts()).isEqualTo(0);
  }

  @Test
  void productOnePartsIsZero() {
    var symbol = Symbol.of(1, 1, "*");
    symbol.addAll(Set.of(Part.of(22, Point.of(0, 0))));
    assertThat(symbol.productOfParts()).isEqualTo(0);
  }

  @Test
  void productTwoPartsIsZero() {
    var symbol = Symbol.of(1, 1, "*");
    symbol.addAll(Set.of(Part.of(3, Point.of(1, 0)), Part.of(3, Point.of(0, 0))));
    assertThat(symbol.productOfParts()).isEqualTo(9);
  }

  @Test
  void productThreePartsIsZero() {
    var symbol = Symbol.of(1, 1, "*");
    symbol.addAll(
        Set.of(Part.of(2, Point.of(1, 0)), Part.of(2, Point.of(2, 0)), Part.of(2, Point.of(1, 2))));
    assertThat(symbol.productOfParts()).isEqualTo(8);
  }
}
