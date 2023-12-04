package nl.roka.adventofcode.aoc2023.day4;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import nl.roka.adventofcode.aoc.Answer;
import nl.roka.adventofcode.aoc.Day;
import nl.roka.adventofcode.aoc.Runner;
import nl.roka.adventofcode.aoc2023.AbstractDayPuzzle;

public class Day4 extends AbstractDayPuzzle {

  public static void main(String[] args) {
    Runner.run(new Day4());
  }

  public Day4() {
    super(new Day(4));
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
    Map<Integer, Integer> obtainedCards =
        day.stream()
            .map(Card::toCard)
            .map(Card::number)
            .collect(Collectors.toMap(Function.identity(), (c) -> 1));

    day.stream()
        .map(Card::toCard)
        .forEach(
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
