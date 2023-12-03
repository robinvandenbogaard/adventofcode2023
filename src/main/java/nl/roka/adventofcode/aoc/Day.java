package nl.roka.adventofcode.aoc;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

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

  public Stream<Line> stream() {
    reader.reset();
    return reader.stream();
  }

  public int number() {
    return number;
  }

  public Grid fullGrid() {
    return Grid.of(reader);
  }
}
