package nl.roka.adventofcode.aoc2023.day2;

import nl.roka.adventofcode.aoc.Answer;
import nl.roka.adventofcode.aoc.Day;
import nl.roka.adventofcode.aoc.LineReader;
import nl.roka.adventofcode.aoc2023.AbstractdayPuzzle;

public class Day2 extends AbstractdayPuzzle {

  public Day2() {
    super(new Day(2));
  }

  public Day2(LineReader reader) {
    super(new Day(2, reader));
  }

  @Override
  public Answer runSilver() {
    var input = Input.of(12,13,14);
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
    return Answer.TBD;
  }
}
