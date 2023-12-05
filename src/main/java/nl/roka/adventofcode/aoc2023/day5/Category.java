package nl.roka.adventofcode.aoc2023.day5;

import java.util.List;

public record Category(String from, String to, List<Mapping> mapping) {

  @Override
  public String toString() {
    return "Category[" + "from=" + from + ", " + "to=" + to + ", " + "mapping=" + mapping + ']';
  }
}
