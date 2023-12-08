package nl.roka.adventofcode.aoc2023.day8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nl.roka.adventofcode.aoc.input.Line;
import nl.roka.adventofcode.aoc.puzzle.Day;
import org.junit.jupiter.api.Test;

class MapsTest {
  @Test
  void parseSequence() {
    var maps = Maps.parse(List.of("LR"));
    assertThat(maps.next()).isEqualTo('L');
    assertThat(maps.next()).isEqualTo('R');
    assertThat(maps.next()).isEqualTo('L');
  }

  @Test
  void parseNode() {
    var maps = Maps.parse(new Day(8).stream().map(Line::text).toList());
    var a = Path.id("AAA");
    var b = Path.id("BBB");
    var z = Path.id("ZZZ");

    assertThat(maps.get(a)).isEqualTo(new Node(b, b));
    assertThat(maps.get(b)).isEqualTo(new Node(a, z));
    assertThat(maps.get(z)).isEqualTo(new Node(z, z));
  }
}
