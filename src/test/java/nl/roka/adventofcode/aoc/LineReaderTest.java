package nl.roka.adventofcode.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LineReaderTest {

  @Test
  void readLine() {
    var reader = LineReader.of("/linereaderTest.in");

    assertThat(reader.nextLine()).isEqualTo(Line.of("1abc2"));
    assertThat(reader.nextLine()).isEqualTo(Line.of("pqr3stu8vwx"));
    assertThat(reader.nextLine()).isEqualTo(Line.of("a1b2c 3d4e5f"));
    assertThat(reader.nextLine()).isEqualTo(Line.of("treb7uchet"));
    assertThat(reader.nextLine()).isEqualTo(Line.none());
  }

  @Test
  void stream() {
    var allLines = LineReader.of("/linereaderTest.in").stream().toList();

    assertThat(allLines)
        .containsExactly(
            Line.of("1abc2"),
            Line.of("pqr3stu8vwx"),
            Line.of("a1b2c 3d4e5f"),
            Line.of("treb7uchet"));
  }

  @Test
  void streamTwiceNeedsAReset() {
    LineReader lineReader = LineReader.of("/linereaderTest.in");

    assertThat(lineReader.stream().toList())
            .containsExactly(
                    Line.of("1abc2"),
                    Line.of("pqr3stu8vwx"),
                    Line.of("a1b2c 3d4e5f"),
                    Line.of("treb7uchet"));

    assertThat(lineReader.stream().toList())
            .isEmpty();
  }

  @Test
  void streamTwiceAfterReset() {
    LineReader lineReader = LineReader.of("/linereaderTest.in");

    assertThat(lineReader.stream().toList())
            .containsExactly(
                    Line.of("1abc2"),
                    Line.of("pqr3stu8vwx"),
                    Line.of("a1b2c 3d4e5f"),
                    Line.of("treb7uchet"));

    lineReader.reset();

    assertThat(lineReader.stream().toList())
            .containsExactly(
                    Line.of("1abc2"),
                    Line.of("pqr3stu8vwx"),
                    Line.of("a1b2c 3d4e5f"),
                    Line.of("treb7uchet"));
  }

  @Test
  void lineCount() {
    LineReader lineReader = LineReader.of("/linereaderTest.in");
    assertThat(lineReader.lineCount()).isEqualTo(4);
  }
}
