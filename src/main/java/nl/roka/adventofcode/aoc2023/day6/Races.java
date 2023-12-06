package nl.roka.adventofcode.aoc2023.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record Races(List<Race> races) {

  public static Races of(List<String> input) {
    var times =
        Arrays.stream(input.get(0).substring(10).split(" "))
            .map(String::trim)
            .filter(s -> !s.isBlank())
            .map(Integer::parseInt)
            .toList();
    var distance =
        Arrays.stream(input.get(1).substring(10).split(" "))
            .map(String::trim)
            .filter(s -> !s.isBlank())
            .map(Integer::parseInt)
            .toList();

    var races = new ArrayList<Race>();
    for (int index = 0; index < times.size(); index++) {
      races.add(Race.of(times.get(index), distance.get(index)));
    }

    return new Races(races);
  }

  public List<Race> toList() {
    return races();
  }
}
