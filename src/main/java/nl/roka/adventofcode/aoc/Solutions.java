package nl.roka.adventofcode.aoc;

public record Solutions(Answer silver, Answer gold) {
  public static Solutions none() {
    return new Solutions(Answer.TBD, Answer.TBD);
  }
}
