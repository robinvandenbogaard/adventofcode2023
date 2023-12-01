package nl.roka.adventofcode.aoc;

import java.util.Objects;
import java.util.function.Consumer;

public class Day {
  private final LineReader reader;
  private final int number;

  public Day(int number) {
    this(number, LineReader.of("/day%d.in".formatted(number)));
  }

  public Day(int number, LineReader reader) {
    this.reader = reader;
    this.number = number;
  }

  public void forEach(Consumer<? super String> action) {
    reader.reset();
    Objects.requireNonNull(action);
    var line = reader.nextLine();
    while (!Objects.equals(line, Line.none())) {
      action.accept(line.text());
      line = reader.nextLine();
    }
  }

  public int number() {
    return number;
  }
}
