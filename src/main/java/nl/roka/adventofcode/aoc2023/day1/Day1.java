package nl.roka.adventofcode.aoc2023.day1;

import nl.roka.adventofcode.aoc.input.LineReader;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day1 extends AbstractDayPuzzle {

  public static void main(String[] args) {
    Runner.run(new Day1());
  }

  public Day1() {
    super(new Day(1), Solutions.of(54159, 53866));
  }

  public Day1(LineReader reader) {
    super(new Day(1, reader), Solutions.of(54159, 53866));
  }

  @Override
  public Answer runSilver() {
    Sum silverSum = new Sum();
    logger.debug("SILVER");
    day.forEach(
        line -> {
          var increment = Digits.ofSingleDigit(line).calibrationValue();
          silverSum.add(increment);
          logger.debug("  {} + {} = {}", silverSum.value - increment, increment, silverSum.value);
        });
    return Answer.of(silverSum.value);
  }

  @Override
  public Answer runGold() {
    Sum goldSum = new Sum();
    logger.debug("GOLD");
    day.forEach(
        line -> {
          var increment = Digits.ofWordedDigit(line).calibrationValue();
          goldSum.add(increment);
          logger.debug("  {} + {} = {}", goldSum.value - increment, increment, goldSum.value);
        });
    return Answer.of(goldSum.value);
  }
}
