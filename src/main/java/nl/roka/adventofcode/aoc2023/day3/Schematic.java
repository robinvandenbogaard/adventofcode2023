package nl.roka.adventofcode.aoc2023.day3;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import nl.roka.adventofcode.aoc.Grid;

class Schematic {
  private final List<Symbol> symbols;
  private final List<Part> parts;

  public Schematic(List<Symbol> symbols, List<Part> parts) {
    this.symbols = symbols;
    this.parts = parts;
  }

  public static Schematic parse(Grid grid) {
    SymbolLocations locations = new SymbolLocations();

    for (int row = 0; row < grid.width(); row++) {
      locations.scanAndAppendAllSymbols(row, grid.row(row));
    }

    var parts =
        locations.symbols().stream()
            .flatMap(
                symbol -> {
                  Set<Part> symbolParts = Part.find(symbol.point(), grid);
                  symbol.addAll(symbolParts);
                  return symbolParts.stream();
                })
            .toList();

    return new Schematic(locations.symbols(), parts);
  }

  public Stream<Part> parts() {
    return parts.stream();
  }

  public List<Symbol> gears() {
    return symbols.stream().filter(Symbol::isGear).toList();
  }
}
