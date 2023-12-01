package nl.roka.adventofcode.aoc;

public class Runnner {

  public static final int MAX_FILLER_LENGTH = 2;

  public static String run(DayPuzzle puzzle) {

    var silver = puzzle.runSilver();
    var gold = puzzle.runGold();

    var result =
        "Day %s: [silver='%s', gold='%s']"
            .formatted(format(puzzle.dayNumber()), silver.text(), gold.text());
    System.out.println(result);
    return result;
  }

  private static String format(int day) {
    return leadWithZeros(String.valueOf(day));
  }

  private static String leadWithZeros(String text) {
    if (text.length() > MAX_FILLER_LENGTH) {
      return text;
    } else {
      var missingCharacters = MAX_FILLER_LENGTH - text.length() + 1;
      return "0".repeat(missingCharacters) + text;
    }
  }
}
