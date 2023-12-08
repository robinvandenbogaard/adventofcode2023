package nl.roka.adventofcode.aoc2023.day8;

import nl.roka.adventofcode.aoc.input.Line;
import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day8 extends AbstractDayPuzzle {

  public static final Solutions SOLUTIONS = Solutions.of("18827", "20220305520997");

  public static void main(String[] args) {
    Runner.run(new Day8());
  }

  public Day8() {
    super(new Day(8), SOLUTIONS);
  }

  public Day8(LineReader reader) {
    super(new Day(8, reader), Solutions.silver(18827));
  }

  @Override
  public Answer runSilver() {
    Maps maps = Maps.parse(day.stream().map(Line::text).toList());
    var current = maps.getAAA();
    var steps = 0;
    while (current != maps.getZZZ()) {
      steps++;
      current =
          switch (maps.next()) {
            case 'L' -> maps.get(current.left());
            case 'R' -> maps.get(current.right());
            default -> throw new IllegalStateException("unknown char");
          };
    }
    return Answer.of(steps);
  }

  @Override
  public Answer runGold() {
    Maps maps = Maps.parse(day.stream().map(Line::text).toList());
    var current = maps.getEndingWithA();
    return Answer.of(current.calculateUsingLcm(maps));
  }
}
