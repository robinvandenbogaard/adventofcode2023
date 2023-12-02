package nl.roka.adventofcode.aoc;

import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LineReader {
  private final String file;
  private Scanner scanner;

  private LineReader(String file) {
    this.file = file;
  }

  public static LineReader of(String file) {
    return new LineReader(file).reset();
  }

  public Line nextLine() {
    if (scanner.hasNextLine()) {
      return Line.of(scanner.nextLine());
    }
    return Line.none();
  }

  public Stream<Line> stream() {
    return StreamSupport.stream(scanner.tokens().spliterator(), false).map(Line::of);
  }

  public LineReader reset() {
    scanner = new Scanner(Objects.requireNonNull(LineReader.class.getResourceAsStream(file)));
    return this;
  }
}
