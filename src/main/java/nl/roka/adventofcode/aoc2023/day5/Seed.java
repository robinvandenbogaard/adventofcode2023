package nl.roka.adventofcode.aoc2023.day5;

import java.math.BigInteger;
import java.util.function.Consumer;

public record Seed(BigInteger number, BigInteger length) {

  public Seed(long number, long length) {
    this(BigInteger.valueOf(number), BigInteger.valueOf(length));
  }

  public static Seed of(long nr) {
    return new Seed(BigInteger.valueOf(nr), BigInteger.ONE);
  }

  public static Seed of(BigInteger nr) {
    return new Seed(nr, BigInteger.ONE);
  }

  public void forEach(Consumer<Seed> seedConsumer) {
    var looper = BigInteger.ZERO;

    while (looper.add(BigInteger.ONE).compareTo(length) <= 0) {
      seedConsumer.accept(Seed.of(number.add(looper)));
      looper = looper.add(BigInteger.ONE);
    }
  }
}
