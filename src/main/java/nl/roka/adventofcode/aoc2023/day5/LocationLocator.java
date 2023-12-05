package nl.roka.adventofcode.aoc2023.day5;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocationLocator {
  private static final Logger log = LoggerFactory.getLogger(LocationLocator.class);

  public static BigInteger locate(Seed root, List<Category> categories) {
    AtomicReference<BigInteger> destination = new AtomicReference<>(Day5.MAX_BIGINTEGER);
    root.forEach(
        seed -> {
          log.debug("{}", seed);
          BigInteger currDestination = seed.number();
          for (var category : categories) {
            var source = currDestination;
            currDestination = category.getDestination(source);
            log.trace(
                "from: {}, to: {}, source: {}, destination: {}",
                category.from(),
                category.to(),
                source,
                currDestination);
          }
          destination.set(
              destination.get() == null ? currDestination : currDestination.min(destination.get()));
          log.debug("current candidate = {}", destination.get());
        });
    log.debug("actual result {}", destination.get());
    return destination.get();
  }
}
