package nl.roka.adventofcode.aoc2023.day5;

import java.math.BigInteger;
import java.util.function.Consumer;

record Seed(BigInteger number, BigInteger length) {

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

  public boolean hasOverlap(Seed other) {
    return between(minValue(), other) || between(maxValue(), other);
  }

  public boolean between(BigInteger value, Seed other) {
    return value.compareTo(other.minValue()) >= 0 && value.compareTo(other.maxValue()) <= 0;
  }

  public BigInteger maxValue() {
    return number.add(length.subtract(BigInteger.ONE));
  }

  public BigInteger minValue() {
    return number;
  }

  public Seed merge(Seed other) {
    var number = minValue().min(other.minValue());
    var newLength = length.add(other.length);
    return new Seed(number, newLength.subtract(BigInteger.TWO));
  }
}
