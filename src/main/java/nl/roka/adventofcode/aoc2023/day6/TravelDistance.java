package nl.roka.adventofcode.aoc2023.day6;

public record TravelDistance(int distance) {
  public boolean greaterThan(Distance distance) {
    return this.distance > distance.millimeters();
  }
}
