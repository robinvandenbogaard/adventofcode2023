package nl.roka.adventofcode.aoc2023.day3;

import java.util.Objects;
import java.util.Set;
import nl.roka.adventofcode.aoc.input.Point;

final class Symbol {
  private final Point point;
  private final String symbol;
  private Set<Part> symbolParts;

  Symbol(Point point, String symbol) {
    this.point = point;
    this.symbol = symbol;
    symbolParts = Set.of();
  }

  static Symbol of(int row, int column, String symbol) {
    return new Symbol(Point.of(row, column), symbol);
  }

  public void addAll(Set<Part> symbolParts) {
    this.symbolParts = symbolParts;
  }

  public Point point() {
    return point;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Symbol) obj;
    return Objects.equals(this.point, that.point) && Objects.equals(this.symbol, that.symbol);
  }

  @Override
  public int hashCode() {
    return Objects.hash(point, symbol);
  }

  @Override
  public String toString() {
    return "Symbol[" + "point=" + point + ", " + "symbol=" + symbol + ']';
  }

  public Set<Part> symbolParts() {
    return symbolParts;
  }

  public boolean isGear() {
    return "*".equals(symbol);
  }

  public int productOfParts() {
    if (!isGear()) {
      throw new IllegalStateException(
          "Cannot compute product unless it is a gear. This has symbol " + symbol);
    }
    if (symbolParts.size() <= 1) {
      return 0;
    } else {
      return symbolParts.stream().mapToInt(Part::value).reduce(1, (x, y) -> x * y);
    }
  }
}
