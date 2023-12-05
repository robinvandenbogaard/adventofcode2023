package nl.roka.adventofcode.aoc2023.day5;

import java.math.BigInteger;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocationLocator {
  private static final Logger log = LoggerFactory.getLogger(LocationLocator.class);

  public static BigInteger locate(Seed seed, List<Category> categories) {
    BigInteger source = seed.number();
    BigInteger destination = BigInteger.ZERO;
    for (var category : categories) {
      destination = category.getDestination(source);
      log.debug(
          "from: {}, to: {}, source: {}, destination: {}",
          category.from(),
          category.to(),
          source,
          destination);
    }
    return destination;
  }
}
