package nl.roka.adventofcode.aoc2023.day3;

import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day3 extends AbstractDayPuzzle {

  public static void main(String[] args) {
    Runner.run(new Day3());
  }

  public Day3() {
    super(new Day(3), Solutions.of(540212, 87605697));
  }

  public Day3(LineReader reader) {
    super(new Day(3, reader));
  }

  @Override
  public Answer runSilver() {
    var sum = Schematic.parse(day.fullGrid()).parts().mapToInt(Part::value).sum();
    return Answer.of(sum);
  }

  @Override
  public Answer runGold() {
    var sum =
        Schematic.parse(day.fullGrid()).gears().stream().mapToInt(Symbol::productOfParts).sum();
    return Answer.of(sum);
  }
}
