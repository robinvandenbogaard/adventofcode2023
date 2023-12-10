package nl.roka.adventofcode.aoc2023.day10;

import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;

public class Day10 extends AbstractDayPuzzle {

  private static final Solutions solutions = Solutions.of("TBD", "TBD");

  public Day10() {
    super(new Day(10), solutions);
  }

  @Override
  public Answer runSilver() {
    var pipes = new Pipes(day.fullGrid());
    return Answer.of(pipes.calcSteps());
  }

  @Override
  public Answer runGold() {
    return Answer.TBD;
  }
}
