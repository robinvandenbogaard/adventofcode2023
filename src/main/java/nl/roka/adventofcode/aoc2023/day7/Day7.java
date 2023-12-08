package nl.roka.adventofcode.aoc2023.day7;

import java.util.List;
import java.util.stream.IntStream;
import nl.roka.adventofcode.aoc.input.Line;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day7 extends AbstractDayPuzzle {

  public static void main(String[] args) {
    Runner.run(new Day7());
  }

  public Day7() {
    super(new Day(7), Solutions.of(250957639, 251515496));
  }

  @Override
  public Answer runSilver() {
    var hands =
        day.stream().map(Line::text).map(Hand::parse).sorted(HandComparator::compare).toList();
    return getAnswer(hands);
  }

  @Override
  public Answer runGold() {
    var hands =
        day.stream()
            .map(Line::text)
            .map(Hand::parseWithJoker)
            .sorted(HandComparator::compareWithJoker)
            .toList();
    return getAnswer(hands);
  }

  private static Answer getAnswer(List<Hand> hands) {
    return Answer.of(
        IntStream.range(0, hands.size())
            .mapToObj(index -> hands.get(index).ranked(index + 1))
            .mapToInt(RankedHand::score)
            .sum());
  }
}
