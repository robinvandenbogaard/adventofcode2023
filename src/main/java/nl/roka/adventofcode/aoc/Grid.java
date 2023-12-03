package nl.roka.adventofcode.aoc;

public class Grid {
  private final char[][] grid;

  public Grid(char[][] grid) {
    this.grid = grid;
  }

  public static Grid of(LineReader reader) {
    var columnCount = reader.nextLine().lenght();
    reader.reset();
    var rowCount = reader.lineCount();
    reader.reset();

    char[][] grid = new char[rowCount][columnCount];

    for(int row = 0; row < rowCount; row++) {
      grid[row] = reader.nextLine().text().toCharArray();
    }

    return new Grid(grid);
  }

  public String get(int row, int column) {
    return String.valueOf(grid[row][column]);
  }
}
