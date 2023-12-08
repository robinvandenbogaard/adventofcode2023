package nl.roka.adventofcode.aoc2023.day8;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PathTest {

  @Test
  void id() {
    assertThat(Path.id("AAA")).isEqualTo(new Path("AAA"));
  }

  @Test
  void left() {
    assertThat(Path.left("       BBB")).isEqualTo(new Path("BBB"));
  }

  @Test
  void right() {
    assertThat(Path.right("            CCC")).isEqualTo(new Path("CCC"));
  }
}
