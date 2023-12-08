package nl.roka.adventofcode.aoc2023.day8;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PathTest {

  @Test
  void id() {
    assertThat(Path.id("AAA")).isEqualTo(new Path("AAA", true, false));
  }

  @Test
  void left() {
    assertThat(Path.left("       BBB")).isEqualTo(new Path("BBB", false, false));
  }

  @Test
  void right() {
    assertThat(Path.right("            ZZZ")).isEqualTo(new Path("ZZZ", false, true));
  }
}
