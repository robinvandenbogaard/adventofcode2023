package nl.roka.adventofcode.aoc2023.day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryBuilder {
  private String from;
  private String string;
  private final List<Mapping> mapping = new ArrayList<>();

  private CategoryBuilder() {}

  public static CategoryBuilder builder() {
    return new CategoryBuilder();
  }

  public CategoryBuilder from(String from) {
    this.from = from;
    return this;
  }

  public CategoryBuilder to(String string) {
    this.string = string;
    return this;
  }

  public CategoryBuilder addMapping(Mapping mapping) {
    this.mapping.add(mapping);
    return this;
  }

  public Category build() {
    return new Category(from, string, Collections.unmodifiableList(mapping));
  }
}
