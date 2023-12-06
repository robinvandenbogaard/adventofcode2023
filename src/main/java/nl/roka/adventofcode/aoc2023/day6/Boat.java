package nl.roka.adventofcode.aoc2023.day6;

public class Boat {
  private Speed speed = new Speed(0);

  public Speed speed() {
    return speed;
  }

  public Boat holdButtonFor(int millis) {
    speed = new Speed(speed.millis() + millis);
    return this;
  }

  public TravelDistance release(int raceTime) {
    var remainingTime = raceTime - speed().millis();
    var distance = new TravelDistance(remainingTime * speed().millis());
    speed = new Speed(0);
    return distance;
  }
}
