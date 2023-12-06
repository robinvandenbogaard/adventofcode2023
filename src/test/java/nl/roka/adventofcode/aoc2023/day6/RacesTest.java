package nl.roka.adventofcode.aoc2023.day6;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacesTest {
  @Test
  void parsing() {
    var races = Races.of(List.of("Time:      7  15   30", "Distance:  9  40  200"));
    assertThat(races.toList()).containsExactly(Race.of(7, 9), Race.of(15, 40), Race.of(30, 200));
  }
}
