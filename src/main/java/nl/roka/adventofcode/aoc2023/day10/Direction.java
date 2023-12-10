package nl.roka.adventofcode.aoc2023.day10;

import nl.roka.adventofcode.aoc.input.Point;

public enum Direction {
  NORTH,
  SOUTH,
  EAST,
  WEST;

  public Point move(Point point) {
    return switch (this) {
      case NORTH -> point.north();
      case SOUTH -> point.south();
      case EAST -> point.east();
      case WEST -> point.west();
    };
  }

  public Direction opposite() {
    return switch (this) {
      case NORTH -> SOUTH;
      case SOUTH -> NORTH;
      case EAST -> WEST;
      case WEST -> EAST;
    };
  }
}
