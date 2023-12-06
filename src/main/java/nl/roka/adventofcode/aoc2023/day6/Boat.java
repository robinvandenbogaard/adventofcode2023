package nl.roka.adventofcode.aoc2023.day6;

import java.math.BigInteger;

public class Boat {
  private Speed speed = new Speed(BigInteger.ZERO);

  public Speed speed() {
    return speed;
  }

  public Boat holdButtonFor(BigInteger millis) {
    speed = speed.add(millis);
    return this;
  }

  public TravelDistance release(BigInteger raceTime) {
    var remainingTime = raceTime.subtract(speed().millis());
    var distance = new TravelDistance(remainingTime.multiply(speed().millis()));
    speed = new Speed(BigInteger.ZERO);
    return distance;
  }
}
