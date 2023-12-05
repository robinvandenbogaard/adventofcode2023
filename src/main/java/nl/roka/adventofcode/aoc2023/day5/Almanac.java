package nl.roka.adventofcode.aoc2023.day5;

import java.util.List;
import java.util.stream.Stream;
import nl.roka.adventofcode.aoc.Line;

class Almanac {
  private final List<Seed> seeds;
  private final List<Category> categories;

  Almanac(List<Seed> seeds, List<Category> categories) {
    this.seeds = seeds;
    this.categories = categories;
  }

  public static Almanac from(Stream<Line> stream) {
    var builder = new AlmanacBuilder();
    stream.map(Line::text).forEach(builder::append);
    return builder.build();
  }

  public List<Seed> seeds() {
    return seeds;
  }

  public Category getCategory(int i) {
    return categories.get(i);
  }
}
