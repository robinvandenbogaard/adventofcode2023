package nl.roka.adventofcode.aoc2023.day4;

import nl.roka.adventofcode.aoc.Answer;
import nl.roka.adventofcode.aoc.Day;
import nl.roka.adventofcode.aoc.Runner;
import nl.roka.adventofcode.aoc2023.AbstractDayPuzzle;

public class Day4 extends AbstractDayPuzzle {

  public static void main(String[] args) {
    Runner.run(new Day4());
  }

  public Day4() {
    super(new Day(4));
  }

  @Override
  public Answer runSilver() {
    return Answer.of(
        day.stream()
            .map(Card::toCard)
            .mapToLong(Card::countMatches)
            .map(ScoreCalculator::score)
            .sum());
  }

  @Override
  public Answer runGold() {
    return Answer.TBD;
  }
}
