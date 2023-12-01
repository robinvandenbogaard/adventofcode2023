package nl.roka.adventofcode.aoc2023;

import java.util.Objects;
import nl.roka.adventofcode.aoc.Day;
import nl.roka.adventofcode.aoc.DayPuzzle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractdayPuzzle implements DayPuzzle {
  protected final Logger logger = LoggerFactory.getLogger(getClass());

  protected final Day day;

  public AbstractdayPuzzle(Day day) {
    this.day = Objects.requireNonNull(day);
  }

  @Override
  public int dayNumber() {
    return day.number();
  }
}
