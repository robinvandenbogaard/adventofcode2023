package nl.roka.adventofcode.aoc2023.day3;

import nl.roka.adventofcode.aoc.Point;

record Symbol(Point point, String symbol) {

  static Symbol of(int row, int column, String symbol) {
    return new Symbol(Point.of(row, column), symbol);
  }
}
