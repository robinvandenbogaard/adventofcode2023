package nl.roka.adventofcode.aoc2023.day10;

import static nl.roka.adventofcode.aoc2023.day10.Direction.EAST;
import static nl.roka.adventofcode.aoc2023.day10.Direction.NORTH;
import static nl.roka.adventofcode.aoc2023.day10.Direction.SOUTH;
import static nl.roka.adventofcode.aoc2023.day10.Direction.WEST;

import java.util.Optional;
import nl.roka.adventofcode.aoc.input.Grid;
import nl.roka.adventofcode.aoc.input.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * .....
 * .F-7.
 * .|.|.
 * .L-J.
 * .....
 *
 *
 *   N
 * W   E
 *   S
 */
public enum Type {
  VERTICAL("|", NORTH, SOUTH),
  HORIZONTAL("-", WEST, EAST),
  BEND_L("L", NORTH, EAST),
  BEND_J("J", WEST, NORTH),
  BEND_7("7", SOUTH, WEST),
  BEND_F("F", EAST, SOUTH);

  private static final Logger log = LoggerFactory.getLogger(Type.class);

  private final String symbol;
  private final Direction forward;
  private final Direction backwards;

  Type(String symbol, Direction forward, Direction backwards) {

    this.symbol = symbol;
    this.forward = forward;
    this.backwards = backwards;
  }

  public static Type of(Grid grid, Point position) {
    return symbolToType(grid.get(position)).orElseThrow();
  }

  private static Optional<Type> symbolToType(String symbol) {
    return switch (symbol) {
      case "|" -> Optional.of(VERTICAL);
      case "-" -> Optional.of(HORIZONTAL);
      case "L" -> Optional.of(BEND_L);
      case "J" -> Optional.of(BEND_J);
      case "7" -> Optional.of(BEND_7);
      case "F" -> Optional.of(BEND_F);
      default -> Optional.empty();
    };
  }

  public boolean contains(Direction direction) {
    return direction.equals(forward) || direction.equals(backwards);
  }

  public boolean fitsFor(Grid grid, Point point) {
    return fits(grid, point, forward) && fits(grid, point, backwards);
  }

  private boolean fits(Grid grid, Point point, Direction direction) {
    String connectedSymbol = grid.get(direction.move(point));
    Direction opposite = direction.opposite();
    log.debug("Checking if '{}' fits at {} matching against ", connectedSymbol, opposite);
    return symbolToType(connectedSymbol).map(t -> t.contains(opposite)).orElse(false);
  }

  public Direction getExit(Direction entered) {
    return forward.equals(entered) ? backwards : forward;
  }

  public Direction backwards() {
    return backwards;
  }

  public String symbol() {
    return symbol;
  }
}
