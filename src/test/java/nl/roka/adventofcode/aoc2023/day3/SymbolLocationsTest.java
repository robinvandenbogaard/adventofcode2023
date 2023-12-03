package nl.roka.adventofcode.aoc2023.day3;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import nl.roka.adventofcode.aoc.Line;
import nl.roka.adventofcode.aoc.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SymbolLocationsTest {
  @Test
  void dotIsNotASymbol() {
    var locations = new SymbolLocations();
    locations.scanAndAppendAllSymbols(0, ".");
    assertThat(locations.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
  void numericIsNotASymbol(int digit) {
    var locations = new SymbolLocations();
    locations.scanAndAppendAllSymbols(0, Integer.toString(digit));
    assertThat(locations.isEmpty()).isTrue();
  }

  @Test
  void symbols() {
    var locations = new SymbolLocations();
    locations.scanAndAppendAllSymbols(0, "!@");
    assertThat(locations.symbols()).isEqualTo(List.of(Point.of(0, 0), Point.of(0, 1)));
  }

  @Test
  void append() {
    var locations = new SymbolLocations();
    locations.scanAndAppendAllSymbols(0, "!");
    locations.scanAndAppendAllSymbols(1, "!");
    assertThat(locations.symbols()).isEqualTo(List.of(Point.of(0, 0), Point.of(1, 0)));
  }
}
