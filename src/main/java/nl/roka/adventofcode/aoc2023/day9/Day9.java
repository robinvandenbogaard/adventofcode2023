package nl.roka.adventofcode.aoc2023.day9;

import java.math.BigInteger;
import nl.roka.adventofcode.aoc.input.Line;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day9 extends AbstractDayPuzzle {

  public static void main(String[] args) {
    Runner.run(new Day9());
  }

  public Day9() {
    super(new Day(9), Solutions.silver(1806615041));
  }

  @Override
  public Answer runSilver() {
    return Answer.of(
        day.stream()
            .map(Line::text)
            .map(Sequence::parse)
            .map(SequenceSolver::findNext)
            .reduce(BigInteger.ZERO, BigInteger::add));
  }

  @Override
  public Answer runGold() {
    return Answer.of(
        day.stream()
            .map(Line::text)
            .map(Sequence::parse)
            .map(SequenceSolver::findPrevious)
            .reduce(BigInteger.ZERO, BigInteger::add));
  }
}
