package nl.roka.adventofcode.aoc2023.day3;

import java.util.Objects;
import java.util.Set;
import nl.roka.adventofcode.aoc.Point;

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

  public String symbol() {
    return symbol;
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
}
