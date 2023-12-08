package nl.roka.adventofcode.aoc2023.day8;

public class Sequence {
  private final String sequence;
  private int index;

  public Sequence(String sequence) {
    this.sequence = sequence;
    this.index = 0;
  }

  public char next() {
    var result = sequence.charAt(index);
    index++;
    if (index >= sequence.length()) index = 0;
    return result;
  }
}
