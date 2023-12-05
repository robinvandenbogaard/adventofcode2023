package nl.roka.adventofcode.aoc2023.day5;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import nl.roka.adventofcode.aoc.Day;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LocationLocatorTest {

  private Almanac almanac;

  @BeforeEach
  void setUp() {
    almanac = Almanac.from(new Day(5).stream());
  }

  @ParameterizedTest
  @CsvSource({"79,81", "14,14", "55,57", "13,13"})
  void soilTest(int seedNumber, BigInteger expected) {
    Seed seed = Seed.of(seedNumber);

    var soil = almanac.getCategory(0);

    assertThat(soil.getDestination(seed.number())).isEqualTo(expected);
  }

  /**
   * Seed 79, soil 81, fertilizer 81, water 81, light 74, temperature 78, humidity 78, location 82.
   * Seed 14, soil 14, fertilizer 53, water 49, light 42, temperature 42, humidity 43, location 43.
   * Seed 55, soil 57, fertilizer 57, water 53, light 46, temperature 82, humidity 82, location 86.
   * Seed 13, soil 13, fertilizer 52, water 41, light 34, temperature 34, humidity 35, location 35.
   */
  @ParameterizedTest
  @CsvSource({
    "79, 81, 81, 81, 74, 78, 78, 82",
    "14, 14, 53, 49, 42, 42, 43, 43",
    "55, 57, 57, 53, 46, 82, 82, 86",
    "13, 13, 52, 41, 34, 34, 35, 35"
  })
  void locationsSimulation(
      BigInteger seed,
      BigInteger soil,
      BigInteger fertilizer,
      BigInteger water,
      BigInteger light,
      BigInteger temperature,
      BigInteger humidity,
      BigInteger location) {
    var soil_c = almanac.getCategory(0);
    var fertilizer_c = almanac.getCategory(1);
    var water_c = almanac.getCategory(2);
    var light_c = almanac.getCategory(3);
    var temperature_c = almanac.getCategory(4);
    var humidity_c = almanac.getCategory(5);
    var location_c = almanac.getCategory(6);

    assertThat(soil_c.getDestination(seed)).isEqualTo(soil);
    assertThat(fertilizer_c.getDestination(soil)).isEqualTo(fertilizer);
    assertThat(water_c.getDestination(fertilizer)).isEqualTo(water);
    assertThat(light_c.getDestination(water)).isEqualTo(light);
    assertThat(temperature_c.getDestination(light)).isEqualTo(temperature);
    assertThat(humidity_c.getDestination(temperature)).isEqualTo(humidity);
    assertThat(location_c.getDestination(humidity)).isEqualTo(location);
  }

  @ParameterizedTest
  @CsvSource({"79, 82", "14, 43", "55, 86", "13, 35"})
  void productionTest(BigInteger seed, BigInteger expected) {
    assertThat(LocationLocator.locate(Seed.of(seed), almanac.categories())).isEqualTo(expected);
  }
}
