package nl.roka.adventofcode.aoc2023.day2;

record Input(int red, int green, int blue) {

  public static Input of(int red, int green, int blue) {
    return new Input(red, green, blue);
  }
}
