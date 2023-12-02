package nl.roka.adventofcode.aoc;


public class Runnner {

  public static final int MAX_FILLER_LENGTH = 2;

  public static String run(DayPuzzle puzzle) {

    Clock silverClock, goldClock;
    Answer silver, gold;

    {
      silverClock = Clock.start();
      silver = puzzle.runSilver();
      silverClock.stop();
    }

    {
      goldClock = Clock.start();
      gold = puzzle.runGold();
      goldClock.stop();
    }

    var result =
        """
        Day %s:  [%s]\tsilver = '%s'
                  [%s]\tgold   = '%s'"""
            .formatted(
                format(puzzle.dayNumber()),
                silverClock.print(),
                silver.text(),
                goldClock.print(),
                gold.text());
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
