package nl.roka.adventofcode.aoc2023.day1;

import nl.roka.adventofcode.aoc.Answer;
import nl.roka.adventofcode.aoc.Day;
import nl.roka.adventofcode.aoc.LineReader;
import nl.roka.adventofcode.aoc.Runnner;
import nl.roka.adventofcode.aoc2023.AbstractdayPuzzle;

public class Day1 extends AbstractdayPuzzle {

  public static void main(String[] args) {
    Runnner.run(new Day1());
  }

  public Day1() {
    super(new Day(1));
  }

  public Day1(LineReader reader) {
    super(new Day(1, reader));
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
