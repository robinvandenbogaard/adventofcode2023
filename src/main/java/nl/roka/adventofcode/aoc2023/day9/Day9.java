package nl.roka.adventofcode.aoc2023.day9;

import nl.roka.adventofcode.aoc.input.Line;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;

public class Day9 extends AbstractDayPuzzle {
  public Day9() {
    super(new Day(9));
  }

  @Override
  public Answer runSilver() {
    return Answer.of(
        day.stream()
            .map(Line::text)
            .map(Sequence::parse)
            .mapToLong(SequenceSolver::findNext)
            .sum());
  }

  @Override
  public Answer runGold() {
    return Answer.TBD;
  }
}
