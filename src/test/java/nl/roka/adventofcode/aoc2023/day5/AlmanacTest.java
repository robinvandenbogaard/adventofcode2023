package nl.roka.adventofcode.aoc2023.day5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.List;
import java.util.stream.Stream;
import nl.roka.adventofcode.aoc.input.Line;
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

  @Test
  void findSeedsMerge() {
    var almanac =
        Almanac.fromSeedRange(
            Stream.of(
                Line.of(
                    "seeds: 3943078016 158366385 481035699 103909769 3553279107 15651230 3322093486 189601966 2957349913 359478652 924423181 691197498 2578953067 27362630 124747783 108079254 1992340665 437203822 2681092979 110901631")));
    assertThat(almanac.seeds())
        .containsExactly(
            new Seed(3943078016L, 158366385L),
            new Seed(481035699L, 103909769L),
            new Seed(3553279107L, 15651230L),
            new Seed(3322093486L, 189601966L),
            new Seed(2957349913L, 359478652L),
            new Seed(924423181L, 691197498L),
            new Seed(2578953067L, 27362630L),
            new Seed(124747783L, 108079254L),
            new Seed(1992340665L, 437203822L),
            new Seed(2681092979L, 110901631L));
  }

  @Test
  public void mergable() {
    var seeds =
        List.of(
            new Seed(3943078016L, 158366385L),
            new Seed(481035699L, 103909769L),
            new Seed(3553279107L, 15651230L),
            new Seed(3322093486L, 189601966L),
            new Seed(2957349913L, 359478652L),
            new Seed(924423181L, 691197498L),
            new Seed(2578953067L, 27362630L),
            new Seed(124747783L, 108079254L),
            new Seed(1992340665L, 437203822L),
            new Seed(2681092979L, 110901631L));
    for (int i = 0; i < seeds.size(); i++) {
      for (Seed seed : seeds) {
        var si = seeds.get(i);
        if (si != seed && si.hasOverlap(seed))
          fail("No overlap allowed, fuck there goes my attempt to optimize");
      }
    }
  }
}
