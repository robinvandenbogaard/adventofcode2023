package nl.roka.adventofcode.aoc2023.day5;

import java.math.BigInteger;
import java.util.List;

record Category(String from, String to, List<Mapping> mapping) {

  @Override
  public String toString() {
    return "Category[" + "from=" + from + ", " + "to=" + to + ", " + "mapping=" + mapping + ']';
  }

  public BigInteger getDestination(BigInteger source) {
    var result =
        mapping.stream()
            .filter(map -> map.inRange(source))
            .map(map -> map.getDestination(source))
            .reduce(Day5.MAX_BIGINTEGER, BigInteger::min);
    return result == Day5.MAX_BIGINTEGER ? source : result;
  }
}
