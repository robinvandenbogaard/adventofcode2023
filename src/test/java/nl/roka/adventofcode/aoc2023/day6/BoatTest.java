package nl.roka.adventofcode.aoc2023.day6;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BoatTest {

  public static final BigInteger TEN = BigInteger.valueOf(10);

  @Test
  @DisplayName("Your toy boat has a starting speed of zero millimeters per millisecond.")
  void startingSpeed() {
    assertThat(new Boat().speed()).isEqualTo(new Speed(BigInteger.ZERO));
  }

  @Test
  @DisplayName(
      "For each whole millisecond you spend at the beginning of the race holding down the button, the boat's speed increases by one millimeter per millisecond")
  void increaseSpeed() {
    Boat boat = new Boat();
    boat.holdButtonFor(TEN);
    assertThat(boat.speed()).isEqualTo(new Speed(TEN));
  }

  @Test
  @DisplayName("Reste speed after release")
  void release() {
    Boat boat = new Boat();
    boat.holdButtonFor(TEN);
    boat.release(TEN);
    assertThat(boat.speed()).isEqualTo(new Speed(BigInteger.ZERO));
  }

  @ParameterizedTest
  @CsvSource({"0,7,0", "1,7,6", "4,7,12", "7,7,0"})
  @DisplayName("Distance covered after button pressed")
  void coverage(BigInteger hold, BigInteger raceTime, BigInteger expectedDistance) {
    Boat boat = new Boat();
    boat.holdButtonFor(hold);
    assertThat(boat.release(raceTime)).isEqualTo(new TravelDistance(expectedDistance));
  }
}
