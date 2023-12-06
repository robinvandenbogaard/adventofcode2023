package nl.roka.adventofcode.aoc2023.day6;

public record Race(int timeInMs, Distance distance) {
  public static Race of(int timeInMs, int distanceInMilis) {
    return new Race(timeInMs, Distance.ofMillimeters(distanceInMilis));
  }

  public int numberOfWaysToWin() {
    var boat = new Boat();
    var wins = 0;
    for (int i = 0; i < timeInMs; i++) {
      if (boat.holdButtonFor(i).release(timeInMs).greaterThan(distance)) {
        wins++;
      }
    }
    return wins;
  }
}
