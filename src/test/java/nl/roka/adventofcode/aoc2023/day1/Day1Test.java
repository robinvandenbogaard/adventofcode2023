package nl.roka.adventofcode.aoc2023.day1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Pattern;
import nl.roka.adventofcode.aoc.Answer;
import nl.roka.adventofcode.aoc.LineReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Day1Test {

  @Test
  void silverExample() {
    assertThat(new Day1().runSilver()).isEqualTo(Answer.of("142"));
  }

  @Test
  void goldExample() {
    assertThat(new Day1(LineReader.of("/day1-gold.in")).runGold()).isEqualTo(Answer.of("281"));
  }

  @ParameterizedTest
  @CsvSource({
    "1,11",
    "a1,11",
    "1a,11",
    "a1a,11",
    "22,22",
    "a22,22",
    "2a2,22",
    "22a,22",
    "a2a2,22",
    "2a2a,22",
    "a2a2a,22"
  })
  void singleDigits(String input, int calibratedValue) {
    var digits = Digits.ofSingleDigit(input);
    assertThat(digits.calibrationValue()).isEqualTo(calibratedValue);
  }

  @ParameterizedTest
  @CsvSource({
    "one,11",
    "twothree,23",
    "fiveight,58",
    "two1nine,29",
    "eightwothree,83",
    "abcone2threexyz,13",
    "xtwone3four,24",
    "4nineeightseven2,42",
    "zoneight234,14",
    "7pqrstsixteen,76"
  })
  void wordedDigits(String input, int calibratedValue) {
    var digits = Digits.ofWordedDigit(input);
    assertThat(digits.calibrationValue()).isEqualTo(calibratedValue);
  }

  @Test
  void named_group() {
    var pattern = Pattern.compile("(?<digit>[0-9])");
    var matcher = pattern.matcher("1a5");
    assertThat(matcher.find()).isTrue();
    assertThat(matcher.group("digit")).isEqualTo("1");
    assertThat(matcher.find()).isTrue();
    assertThat(matcher.group("digit")).isEqualTo("5");
    assertThat(matcher.find()).isFalse();
  }

  @Test
  void postive_lookahead_regex() {
    var pattern =
        Pattern.compile("(?=(?<digit>one|two|three|four|five|six|seven|eight|nine|zero))");
    var matcher = pattern.matcher("fiveeight");
    assertThat(matcher.find()).isTrue();
    assertThat(matcher.group("digit")).isEqualTo("five");
    assertThat(matcher.find()).isTrue();
    assertThat(matcher.group("digit")).isEqualTo("eight");
    assertThat(matcher.find()).isFalse();
  }
}
