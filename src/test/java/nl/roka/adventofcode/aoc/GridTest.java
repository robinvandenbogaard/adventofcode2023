package nl.roka.adventofcode.aoc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GridTest {
  @Test
  void gridCreation() {
    Grid grid = Grid.of(LineReader.of("/gridTest.in"));

    assertThat(grid.get(0,0)).isEqualTo("1");
    assertThat(grid.get(0,1)).isEqualTo("2");
    assertThat(grid.get(0,2)).isEqualTo("3");

    assertThat(grid.get(1,0)).isEqualTo("a");
    assertThat(grid.get(1,1)).isEqualTo("b");
    assertThat(grid.get(1,2)).isEqualTo("c");
  }
}
