package nl.roka.adventofcode.aoc;

import java.time.Duration;

record StoppedClock(long nanoTimeStart, long nanoTimeStop) {

  public String print() {
    return humanReadableFormat(Duration.ofNanos(nanoTimeStop - nanoTimeStart));
  }

  public static String humanReadableFormat(Duration duration) {
    return duration.toString().substring(2).replaceAll("(\\d[HMS])(?!$)", "$1 ").toLowerCase();
  }
}
