package nl.roka.adventofcode.aoc2023.day5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import nl.roka.adventofcode.aoc.Line;
import org.junit.jupiter.api.Test;

class AlmanacTest {
  @Test
  void findSeeds() {
    var almanac = Almanac.from(Stream.of(Line.of("seeds: 1 2 3")));
    assertThat(almanac.seeds()).containsExactly(Seed.of(1), Seed.of(2), Seed.of(3));
  }

  @Test
  void findCategory() {
    var almanac = Almanac.from(Stream.of(Line.of("seed-to-soil map:"), Line.of("1 2 2")));
    assertThat(almanac.getCategory(0))
        .isEqualTo(
            CategoryBuilder.builder()
                .from("seed")
                .to("soil")
                .addMapping(Mapping.of(1, 2, 2))
                .build());
  }

  @Test
  void findNCategories() {
    var almanac =
        Almanac.from(
            Stream.of(
                Line.of("seed-to-soil map:"),
                Line.of("1 2 2"),
                Line.of(""),
                Line.of("soil-to-fertilizer map:"),
                Line.of("3 2 8")));
    assertThat(almanac.getCategory(1))
        .isEqualTo(
            CategoryBuilder.builder()
                .from("soil")
                .to("fertilizer")
                .addMapping(Mapping.of(3, 2, 8))
                .build());
  }
}
