package nl.roka.adventofcode.aoc;

public class Runner {

  static final int MAX_FILLER_LENGTH = 2;
  static final int WARMUP_REPETITIONS = 50;

  public static String run(DayPuzzle puzzle) {

    StoppedClock silverClock, goldClock;
    Answer silver, gold;

    {
      var clock = Clock.start();
      silver = puzzle.runSilver();
      silverClock = clock.stop();
    }

    {
      var clock = Clock.start();
      gold = puzzle.runGold();
      goldClock = clock.stop();
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

  public static void warmup(DayPuzzle puzzle) {

    for (int repetition = 0; repetition < WARMUP_REPETITIONS; repetition++) {
      puzzle.runSilver();
      puzzle.runGold();
    }
  }
}
