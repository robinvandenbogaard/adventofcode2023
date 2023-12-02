package nl.roka.adventofcode.aoc2023.day2;

import nl.roka.adventofcode.aoc.Line;

class Game {
  private final int id;

  Game(int id) {
    this.id = id;
  }

  public boolean isPossible(Input input) {
    return false;
  }

  public int id() {
    return id;
  }

  public static Game fromLine(Line line) {
    int id = Integer.parseInt(line.text().substring(5,line.text().indexOf(":")));
    return new Game(id);
  }
}
