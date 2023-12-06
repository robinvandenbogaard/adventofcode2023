package nl.roka.adventofcode.aoc2023.day2;

import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day2 extends AbstractDayPuzzle {

  public static void main(String[] args) {
    Runner.run(new Day2());
  }

  public Day2() {
    super(new Day(2), Solutions.of(2176, 63700));
  }

  @Override
  public Answer runSilver() {
    var input = Input.of(12, 13, 14);
    var sumOfIds =
        day.stream()
            .map(Game::fromLine)
            .filter(game -> game.isPossible(input))
            .mapToInt(Game::id)
            .sum();
    return Answer.of(sumOfIds);
  }

  @Override
  public Answer runGold() {
    var sumOfIds =
        day.stream()
            .map(Game::fromLine)
            .map(Game::fewestNumberOfCubes)
            .mapToInt(GameSet::pow)
            .sum();
    return Answer.of(sumOfIds);
  }
}
