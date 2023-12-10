package nl.roka.adventofcode.aoc2023.day10;

import nl.roka.adventofcode.aoc.input.Grid;
import nl.roka.adventofcode.aoc.input.Point;

public record Pipe(Point location, Type type) {

  public Step stepForward(Grid grid, Direction entered) {
    Direction exit = type.getExit(entered);
    var nexPos = exit.move(location);
    return new Step(this, exit, exit.opposite(), new Pipe(nexPos, Type.of(grid, nexPos)));
  }
}
