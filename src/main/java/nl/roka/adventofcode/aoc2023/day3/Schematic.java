package nl.roka.adventofcode.aoc2023.day3;

import java.util.List;
import java.util.stream.Stream;
import nl.roka.adventofcode.aoc.Grid;

class Schematic {
  private final List<Part> parts;

  public Schematic(List<Part> parts) {
    this.parts = parts;
  }

  public static Schematic parse(Grid grid) {
    SymbolLocations locations = new SymbolLocations();

    for (int row = 0; row < grid.width(); row++) {
      locations.scanAndAppendAllSymbols(row, grid.row(row));
    }

    var parts = locations.symbols().stream().flatMap(symbol -> Part.find(symbol.point(), grid).stream()).toList();

    return new Schematic(parts);
  }

  public Stream<Part> parts() {
    return parts.stream();
  }
}
