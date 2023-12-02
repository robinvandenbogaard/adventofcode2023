package nl.roka.adventofcode.aoc;

import java.time.Duration;

class Clock {
  private final long nanoTimeStart;
  private long nanoTimeStop;

  private Clock(long nanoTimeStart) {
    this.nanoTimeStart = nanoTimeStart;
  }

  static Clock start() {
    return new Clock(System.nanoTime());
  }

  void stop() {
    if (nanoTimeStop != 0)
      throw new IllegalStateException("Clock already stopped");
    nanoTimeStop = System.nanoTime();
  }

  public String print() {
    return humanReadableFormat(Duration.ofNanos(nanoTimeStop - nanoTimeStart));
  }

  public static String humanReadableFormat(Duration duration) {
    return duration
        .toString()
        .substring(2)
        .replaceAll("(\\d[HMS])(?!$)", "$1 ")
        .toLowerCase();
  }
}
