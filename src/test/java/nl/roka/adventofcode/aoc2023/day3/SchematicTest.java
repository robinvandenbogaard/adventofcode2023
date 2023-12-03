package nl.roka.adventofcode.aoc2023.day3;

import nl.roka.adventofcode.aoc.Grid;
import nl.roka.adventofcode.aoc.LineReader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SchematicTest {

  @Test
  void parseSchematic() {
    Schematic schematic = Schematic.parse(Grid.of(LineReader.of("/schematicTest")));
    assertThat(schematic.parts()).containsExactly(Part.of(22), Part.of(1));
  }
}
