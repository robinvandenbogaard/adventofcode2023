package nl.roka.adventofcode.aoc2023.day3;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.input.Grid;
import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.input.Point;
import org.junit.jupiter.api.Test;

class SchematicTest {

  @Test
  void parseSchematic() {
    Schematic schematic = Schematic.parse(Grid.of(LineReader.of("/aoc/schematicTest.in")));
    assertThat(schematic.parts())
        .containsExactlyInAnyOrder(Part.of(22, Point.of(1, 3)), Part.of(1, Point.of(1, 0)));
  }

  @Test
  void parseTwoSymbolsOnePart() {
    Schematic schematic = Schematic.parse(Grid.of(LineReader.of("/aoc/twoSymbolsOnePart.in")));
    assertThat(schematic.parts())
        .containsExactlyInAnyOrder(Part.of(1, Point.of(1, 0)), Part.of(1, Point.of(1, 0)));
  }

  @Test
  void parseOneSymbolTwoIdenticalParts() {
    Schematic schematic =
        Schematic.parse(Grid.of(LineReader.of("/aoc/oneSymbolTwoIdenticalParts.in")));
    assertThat(schematic.parts())
        .containsExactlyInAnyOrder(Part.of(22, Point.of(0, 1)), Part.of(22, Point.of(2, 0)));
  }

  @Test
  void recordPartsAtSymbol() {
    Schematic schematic =
        Schematic.parse(Grid.of(LineReader.of("/aoc/oneSymbolTwoIdenticalParts.in")));
    assertThat(schematic.gears().get(0).symbolParts())
        .containsExactlyInAnyOrder(Part.of(22, Point.of(0, 1)), Part.of(22, Point.of(2, 0)));
  }
}
