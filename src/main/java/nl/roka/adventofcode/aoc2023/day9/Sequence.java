package nl.roka.adventofcode.aoc2023.day9;

import java.util.Arrays;
import java.util.List;

record Sequence(List<Long> values) {

  public static Sequence parse(String input) {
    return new Sequence(
        Arrays.stream(input.split(" ")).mapToLong(Long::parseLong).boxed().toList());
  }

  public static Sequence of(List<Long> diffs) {
    return new Sequence(diffs);
  }

  boolean valuesAreEqual() {
    Long value = values.get(0);
    return values.stream().allMatch(v -> v.equals(value));
  }

  public int size() {
    return values.size();
  }

  public Long diff(int index1, int index2) {
    return Math.abs(values.get(index1) - values.get(index2));
  }

  public long lastValueInSequence() {
    return values.get(values.size() - 1);
  }
}
