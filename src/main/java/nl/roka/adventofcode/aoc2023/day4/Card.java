package nl.roka.adventofcode.aoc2023.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nl.roka.adventofcode.aoc.Line;

public record Card(int number, List<Integer> winning, List<Integer> actual) {

  public static Card toCard(Line line) {
    String text = line.text();
    int endIndex = text.indexOf(":");
    var number = Integer.parseInt(text.substring(5, endIndex).trim());
    var numbers = text.substring(endIndex + 1).split("\\|");
    var winning = toNumberList(numbers[0].split(" "));
    var actual = toNumberList(numbers[1].split(" "));
    return new Card(number, winning, actual);
  }

  private static List<Integer> toNumberList(String[] numbers) {
    return Arrays.stream(numbers)
        .map(String::trim)
        .filter(digit -> !digit.isBlank())
        .map(Integer::parseInt)
        .toList();
  }

  public int countMatches() {
    ArrayList<Integer> copy = new ArrayList<>(winning);
    copy.retainAll(actual);
    return copy.size();
  }
}
