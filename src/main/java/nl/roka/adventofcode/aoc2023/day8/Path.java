package nl.roka.adventofcode.aoc2023.day8;

public record Path(String value, boolean endsWithA, boolean endsWithZ) {
  public static Path id(String node) {
    var value = node.substring(0, 3);
    return new Path(value, value.charAt(2) == 'A', value.charAt(2) == 'Z');
  }

  public static Path left(String node) {
    var value = node.substring(7, 10);
    return new Path(value, value.charAt(2) == 'A', value.charAt(2) == 'Z');
  }

  public static Path right(String node) {
    var value = node.substring(12, 15);
    return new Path(value, value.charAt(2) == 'A', value.charAt(2) == 'Z');
  }
}
