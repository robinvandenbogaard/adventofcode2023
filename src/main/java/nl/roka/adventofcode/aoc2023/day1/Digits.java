package nl.roka.adventofcode.aoc2023.day1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

record Digits(String first, String last) {

  public static final Pattern SINGLE_DIGITS = Pattern.compile("(?<digit>[0-9])");
  public static final Pattern WORDED_DIGITS =
      Pattern.compile("(?=(?<digit>one|two|three|four|five|six|seven|eight|nine|zero|[0-9]))");

  public static Digits of(String first, String last) {
    return new Digits(first, last);
  }

  public static Digits ofSingleDigit(String line) {
    return getDigits(SINGLE_DIGITS.matcher(line));
  }

  public static Digits ofWordedDigit(String line) {
    return getDigits(WORDED_DIGITS.matcher(line));
  }

  private static Digits getDigits(Matcher matcher) {
    String first = null;
    String last = null;
    while (matcher.find()) {
      first = first != null ? first : matcher.group("digit");
      last = matcher.group("digit");
    }
    return Digits.of(first, last);
  }

  public int calibrationValue() {
    return Digit.parseInt(Digit.parseDigit(first), Digit.parseDigit(last));
  }
}
