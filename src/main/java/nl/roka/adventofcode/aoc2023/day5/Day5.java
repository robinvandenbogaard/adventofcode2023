package nl.roka.adventofcode.aoc2023.day5;

import java.math.BigInteger;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.RequireOptimization;
import nl.roka.adventofcode.aoc.runner.Runner;

@RequireOptimization
public class Day5 extends AbstractDayPuzzle {

  public static final BigInteger MAX_BIGINTEGER = new BigInteger("9223372036854775807");

  public static void main(String[] args) {
    Runner.run(new Day5());
  }

  public Day5() {
    super(new Day(5), Solutions.of(424490994, 15290096));
  }

  @Override
  public Answer runSilver() {
    var almanac = Almanac.from(day.stream());
    var nearestLocation =
        almanac.seeds().stream()
            .map(seed -> LocationLocator.locate(seed, almanac.categories()))
            .reduce(MAX_BIGINTEGER, BigInteger::min)
            .toString();
    return Answer.of(nearestLocation);
  }

  @Override
  public Answer runGold() {
    var almanac = Almanac.fromSeedRange(day.stream());
    var nearestLocation =
        almanac.seeds().stream()
            .map(seed -> LocationLocator.locate(seed, almanac.categories()))
            .reduce(MAX_BIGINTEGER, BigInteger::min)
            .toString();
    return Answer.of(nearestLocation);
  }
}
