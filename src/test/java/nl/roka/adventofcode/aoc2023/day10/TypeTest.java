package nl.roka.adventofcode.aoc2023.day10;

import static nl.roka.adventofcode.aoc2023.day10.Direction.*;
import static nl.roka.adventofcode.aoc2023.day10.Type.*;
import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.puzzle.Day;
import org.junit.jupiter.api.Test;

class TypeTest {

  @Test
  void contains() {
    assertThat(BEND_7.contains(SOUTH)).isTrue();
    assertThat(BEND_7.contains(WEST)).isTrue();
    assertThat(BEND_7.contains(NORTH)).isFalse();
    assertThat(BEND_7.contains(EAST)).isFalse();
  }

  @Test
  void fitsFor() {
    var grid = new Day(10).fullGrid();
    assertThat(BEND_L.fitsFor(grid, grid.findSymbol("L"))).isTrue();
  }

  @Test
  void onlyVERTICALfits() {
    var grid = new Day(10).fullGrid();
    assertThat(HORIZONTAL.fitsFor(grid, grid.findSymbol("L"))).isFalse();
    assertThat(VERTICAL.fitsFor(grid, grid.findSymbol("L"))).isFalse();
    assertThat(BEND_7.fitsFor(grid, grid.findSymbol("L"))).isFalse();
    assertThat(BEND_F.fitsFor(grid, grid.findSymbol("L"))).isFalse();
    assertThat(BEND_J.fitsFor(grid, grid.findSymbol("L"))).isFalse();
  }
}
