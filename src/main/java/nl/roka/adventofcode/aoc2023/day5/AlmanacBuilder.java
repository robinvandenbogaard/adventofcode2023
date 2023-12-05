package nl.roka.adventofcode.aoc2023.day5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AlmanacBuilder {
  private final boolean rangedSeeds;
  private List<Seed> seeds = new ArrayList<>();
  private final List<Category> categories = new ArrayList<>();

  private CategoryBuilder categoryBuilder = null;

  public AlmanacBuilder(boolean rangedSeeds) {
    this.rangedSeeds = rangedSeeds;
  }

  public void append(String line) {
    if (isSeeds(line)) {
      parseSeeds(line);
    } else if (line.isBlank()) {
      finishCategory();
    } else if (isCategory(line)) {
      parseCategory(line);
    } else {
      expandCategory(line);
    }
  }

  private boolean isSeeds(String line) {
    return line.startsWith("seeds:");
  }

  private void parseSeeds(String line) {
    String numbersOnly = line.substring(line.indexOf(":") + 2);
    seeds = Arrays.stream(numbersOnly.split(" ")).map(BigInteger::new).map(Seed::of).toList();
    if (rangedSeeds) {
      seeds = toRangedSeeds(seeds);
    }
  }

  private List<Seed> toRangedSeeds(List<Seed> seeds) {
    var result = new ArrayList<Seed>();
    for (int i = 1; i < seeds.size(); i += 2) {
      var seed = seeds.get(i - 1);
      var length = seeds.get(i).number();
      result.add(new Seed(seed.number(), length));
    }
    return result;
  }

  private void finishCategory() {
    if (categoryBuilder != null) {
      categories.add(categoryBuilder.build());
      categoryBuilder = null;
    }
  }

  private boolean isCategory(String line) {
    return line.contains("-to-");
  }

  private void parseCategory(String line) {
    var name = line.substring(0, line.indexOf(" map:"));
    var categories = name.split("-to-");
    categoryBuilder = CategoryBuilder.builder().from(categories[0]).to(categories[1]);
  }

  private void expandCategory(String line) {
    var values = Arrays.stream(line.split(" ")).map(BigInteger::new).toList();
    categoryBuilder.addMapping(new Mapping(values.get(0), values.get(1), values.get(2)));
  }

  public Almanac build() {
    finishCategory(); // last builder if any
    return new Almanac(seeds, categories);
  }
}
