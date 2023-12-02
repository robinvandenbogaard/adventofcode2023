package nl.roka.adventofcode.aoc2023.day2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

record GameSet(int red, int green, int blue) {
  private static final Logger log = LoggerFactory.getLogger(GameSet.class);

  public static GameSet of(Integer red, Integer green, Integer blue) {
    return new GameSet(
        Objects.requireNonNullElse(red, 0),
        Objects.requireNonNullElse(green, 0),
        Objects.requireNonNullElse(blue, 0));
  }

  public static List<GameSet> toSets(String setsLine) {
    return Arrays.stream(setsLine.split(";")).map(GameSet::toSet).toList();
  }

  private static GameSet toSet(String setLine) {
    var pattern =
        Pattern.compile("((?<green>\\d+) green,?)|((?<red>\\d+) red,?)|((?<blue>\\d+) blue?);?");
    var matcher = pattern.matcher(setLine);

    if (!matcher.find())
      throw new IllegalArgumentException(
          "'%s' does not match the game sets pattern.".formatted(setLine));

    Integer red = null, green = null, blue = null;
    do {
      red = getColorCount(matcher, "red", red);
      green = getColorCount(matcher, "green", green);
      blue = getColorCount(matcher, "blue", blue);
    } while (matcher.find());
    return GameSet.of(red, green, blue);
  }

  private static Integer getColorCount(Matcher matcher, String colorGroup, Integer currentColor) {
    return Optional.ofNullable(matcher.group(colorGroup)).map(Integer::parseInt).orElse(currentColor);
  }

  public boolean lessThan(Input input) {
    boolean lessThan = red <= input.red() && green <= input.green() && blue <= input.blue();
    log.info("Compared [lessThan={}] {} with {}", lessThan, this, input);
    return lessThan;
  }
}
