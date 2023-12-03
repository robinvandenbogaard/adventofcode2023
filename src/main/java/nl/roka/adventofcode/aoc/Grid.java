package nl.roka.adventofcode.aoc;

public class Grid {
  private final String[] grid;

  Grid(String[] grid) {
    this.grid = grid;
  }

  public static Grid of(LineReader reader) {
    var rowCount = reader.lineCount();
    reader.reset();

    String[] grid = new String[rowCount];

    for (int row = 0; row < rowCount; row++) {
      Line line = reader.nextLine();
      grid[row] = line.text();
    }

    return new Grid(grid);
  }

  public String get(int row, int column) {
    if (!inBounds(row, column)) return null;
    return String.valueOf(grid[row].toCharArray()[column]);
  }

  private boolean inBounds(int row, int column) {
    return row >= 0 && row < width() && column >= 0 && column < height();
  }

  public int width() {
    return grid.length;
  }

  public int height() {
    return grid[0].length();
  }

  public String row(int row) {
    return grid[row];
  }

  public String get(Point point) {
    return get(point.x(), point.y());
  }
}
