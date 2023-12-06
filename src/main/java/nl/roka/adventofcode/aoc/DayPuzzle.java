package nl.roka.adventofcode.aoc;

public interface DayPuzzle {
  Answer runSilver();

  Answer runGold();

  int dayNumber();

  Answer goldVerified();

  Answer silverVerified();
}
