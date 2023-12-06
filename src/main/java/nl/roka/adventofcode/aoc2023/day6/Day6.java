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
    return Answer.of(
        races.toList().stream().mapToInt(Race::numberOfWaysToWin).reduce(1, (a, b) -> a * b));
  }

  @Override
  public Answer runGold() {
    Race race = Races.ofFixedKerning(day.stream().map(Line::text).toList());
    return Answer.TBD;
  }
}
