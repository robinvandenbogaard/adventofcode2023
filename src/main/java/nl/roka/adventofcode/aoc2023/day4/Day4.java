package nl.roka.adventofcode.aoc2023.day4;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import nl.roka.adventofcode.aoc.puzzle.AbstractDayPuzzle;
import nl.roka.adventofcode.aoc.puzzle.Answer;
import nl.roka.adventofcode.aoc.puzzle.Day;
import nl.roka.adventofcode.aoc.puzzle.Solutions;
import nl.roka.adventofcode.aoc.runner.Runner;

public class Day4 extends AbstractDayPuzzle {

  public static void main(String[] args) {
    Runner.run(new Day4());
  }

  public Day4() {
    super(new Day(4), Solutions.of(20107, 8172507));
  }

  @Override
  public Answer runSilver() {
    return Answer.of(
        day.stream()
            .map(Card::toCard)
            .mapToLong(Card::countMatches)
            .map(ScoreCalculator::score)
            .sum());
  }

  @Override
  public Answer runGold() {
    List<Card> cards = day.stream().map(Card::toCard).toList();

    Map<Integer, Integer> obtainedCards =
        cards.stream().map(Card::number).collect(Collectors.toMap(Function.identity(), (c) -> 1));

    cards.forEach(
        currentCard -> {
          var cardCount = obtainedCards.get(currentCard.number());
          for (int copyNumber = 0; copyNumber < currentCard.countMatches(); copyNumber++) {
            obtainedCards.computeIfPresent(
                currentCard.number() + copyNumber + 1, (k, v) -> v + cardCount);
          }
        });

    return Answer.of(obtainedCards.values().stream().mapToInt(i -> i).sum());
  }
}
