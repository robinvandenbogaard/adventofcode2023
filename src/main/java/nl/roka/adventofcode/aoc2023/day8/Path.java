package nl.roka.adventofcode.aoc2023.day8;

public record Path(String value) {
  public static Path id(String value) {
    return new Path(value.substring(0, 3));
  }

  public static Path left(String node) {
    return new Path(node.substring(7, 10));
  }

  public static Path right(String node) {
    return new Path(node.substring(12, 15));
  }
}
