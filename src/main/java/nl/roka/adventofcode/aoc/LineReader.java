package nl.roka.adventofcode.aoc;

import java.util.Objects;
import java.util.Scanner;

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

  public LineReader reset() {
    scanner = new Scanner(Objects.requireNonNull(LineReader.class.getResourceAsStream(file)));
    return this;
  }
}
