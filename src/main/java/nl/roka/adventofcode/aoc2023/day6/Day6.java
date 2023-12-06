package nl.roka.adventofcode.aoc2023.day6;

import nl.roka.adventofcode.aoc.Answer;
import nl.roka.adventofcode.aoc.Day;
import nl.roka.adventofcode.aoc.Line;
import nl.roka.adventofcode.aoc.Runner;
import nl.roka.adventofcode.aoc2023.AbstractDayPuzzle;

public class Day6 extends AbstractDayPuzzle {

  public static void main(String[] args) {
    Runner.run(new Day6());
  }

  public Day6() {
    super(new Day(6));
  }

  @Override
  public Answer runSilver() {
    Races races = Races.of(day.stream().map(Line::text).toList());
    int score = 1;
    for (int i = 0; i < races.races().size(); i++) {
      score = score * races.races().get(i).numberOfWaysToWin();
    }
    return Answer.of(score);
  }

  @Override
  public Answer runGold() {
    return Answer.TBD;
  }
}
