package nl.roka.adventofcode.aoc2023.day1;

class Digit {
  public static String parseDigit(String text) {
    try {
      return "" + Integer.parseInt(text);
    } catch (NumberFormatException e) {
      return switch (text) {
        case "one" -> "1";
        case "two" -> "2";
        case "three" -> "3";
        case "four" -> "4";
        case "five" -> "5";
        case "six" -> "6";
        case "seven" -> "7";
        case "eight" -> "8";
        case "nine" -> "9";
        case "zero" -> "0";
        default -> throw new IllegalStateException("Unexpected value: " + text);
      };
    }
  }

  public static int parseInt(String first, String last) {
    return Integer.parseInt(first + last);
  }
}
