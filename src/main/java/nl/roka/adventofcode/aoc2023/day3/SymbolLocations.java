package nl.roka.adventofcode.aoc2023.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SymbolLocations {

  public static final Pattern SYMBOL_PATTERN = Pattern.compile("[^\\.\\w\\s]");
  private final List<Symbol> symbols;

  SymbolLocations() {
    symbols = new ArrayList<>();
  }

  public void scanAndAppendAllSymbols(int row, String line) {
    Matcher m = SYMBOL_PATTERN.matcher(line);
    while (m.find()) {
      symbols.add(Symbol.of(row, m.start(), m.group()));
    }
  }

  public boolean isEmpty() {
    return symbols.isEmpty();
  }

  public List<Symbol> symbols() {
    return symbols;
  }
}
