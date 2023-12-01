package nl.roka.adventofcode.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LineReaderTest {
  @Test
  void readLine() {
    var reader = LineReader.of("/day1.in");

    assertThat(reader.nextLine()).isEqualTo(Line.of("1abc2"));
    assertThat(reader.nextLine()).isEqualTo(Line.of("pqr3stu8vwx"));
    assertThat(reader.nextLine()).isEqualTo(Line.of("a1b2c3d4e5f"));
    assertThat(reader.nextLine()).isEqualTo(Line.of("treb7uchet"));
    assertThat(reader.nextLine()).isEqualTo(Line.none());
  }
}
