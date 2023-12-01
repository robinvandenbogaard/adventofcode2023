package nl.roka.adventofcode.aoc;

public record Answer(String text) {

  public static final Answer TBD = new Answer("TBD");

  public static Answer of(int value) {
    return of("" + value);
  }

  public static Answer of(String text) {
    return new Answer(text);
  }
}
