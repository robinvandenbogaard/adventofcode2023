package nl.roka.adventofcode.aoc2023.day6;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BoatTest {
  @Test
  @DisplayName("Your toy boat has a starting speed of zero millimeters per millisecond.")
  void startingSpeed() {
    assertThat(new Boat().speed()).isEqualTo(new Speed(0));
  }

  @Test
  @DisplayName(
      "For each whole millisecond you spend at the beginning of the race holding down the button, the boat's speed increases by one millimeter per millisecond")
  void increaseSpeed() {
    Boat boat = new Boat();
    boat.holdButtonFor(10);
    assertThat(boat.speed()).isEqualTo(new Speed(10));
  }

  @Test
  @DisplayName("Reste speed after release")
  void release() {
    Boat boat = new Boat();
    boat.holdButtonFor(10);
    boat.release(10);
    assertThat(boat.speed()).isEqualTo(new Speed(0));
  }

  @ParameterizedTest
  @CsvSource({"0,7,0", "1,7,6", "4,7,12", "7,7,0"})
  @DisplayName("Distance covered after button pressed")
  void coverage(int hold, int raceTime, int expectedDistance) {
    Boat boat = new Boat();
    boat.holdButtonFor(hold);
    assertThat(boat.release(raceTime)).isEqualTo(new TravelDistance(expectedDistance));
  }
}
