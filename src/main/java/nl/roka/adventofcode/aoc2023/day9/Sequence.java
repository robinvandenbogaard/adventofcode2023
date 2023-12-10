package nl.roka.adventofcode.aoc2023.day9;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

record Sequence(List<BigInteger> values) {

  public static Sequence parse(String input) {
    return new Sequence(Arrays.stream(input.split(" ")).map(BigInteger::new).toList());
  }

  public static Sequence of(List<BigInteger> diffs) {
    return new Sequence(diffs);
  }

  boolean valuesAreEqual() {
    BigInteger value = values.get(0);
    return values.stream().allMatch(v -> v.equals(value));
  }

  public int size() {
    return values.size();
  }

  public BigInteger diff(int index1, int index2) {
    return values.get(index2).subtract(values.get(index1));
  }

  public BigInteger lastValueInSequence() {
    return values.get(values.size() - 1);
  }
}
