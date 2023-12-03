package nl.roka.adventofcode.aoc2023.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nl.roka.adventofcode.aoc.Point;

class SymbolLocations {

  public static final Pattern SYMBOL_PATTERN = Pattern.compile("[^\\.\\w\\s]");
  private final List<Point> symbols;

  SymbolLocations() {

    symbols = new ArrayList<>();
  }

  public void scanAndAppendAllSymbols(int row, String line) {
    Matcher m = SYMBOL_PATTERN.matcher(line);
    while (m.find()) {
      symbols.add(new Point(row, m.start()));
    }
  }

  public boolean isEmpty() {
    return symbols.isEmpty();
  }

  public List<Point> symbols() {
    return symbols;
  }
}
