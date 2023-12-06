package nl.roka.adventofcode.aoc2023.day6;

public record Distance(int millimeters) {
  public static Distance ofMillimeters(int distanceInMillis) {
    return new Distance(distanceInMillis);
  }
}
