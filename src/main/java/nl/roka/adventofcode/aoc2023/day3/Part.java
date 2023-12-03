package nl.roka.adventofcode.aoc2023.day3;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import nl.roka.adventofcode.aoc.Grid;
import nl.roka.adventofcode.aoc.Point;

record Part(int value, Point start) {

  public static final Pattern PART_NUMBER = Pattern.compile("[0-9]+");

  public static Part of(int value, Point start) {
    return new Part(value, start);
  }

  public static Set<Part> find(Point point, Grid grid) {
    return point.adjecent().stream()
        .filter(p -> isNumeric(grid.get(p)))
        .map(p -> Part.from(p, grid))
        .collect(Collectors.toSet());
  }

  private static Part from(Point p, Grid grid) {
    var matcher = PART_NUMBER.matcher(grid.row(p.x()));

    while (matcher.find()) {
      var position = matcher.start();
      var number = matcher.group();
      if (p.y() >= position && p.y() < number.length() + position)
        return Part.of(Integer.parseInt(number), p.setY(position));
    }

    throw new IllegalArgumentException("Part not found, but it MUST exist");
  }

  private static boolean isNumeric(String text) {
    try {
      Integer.parseInt(text);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
