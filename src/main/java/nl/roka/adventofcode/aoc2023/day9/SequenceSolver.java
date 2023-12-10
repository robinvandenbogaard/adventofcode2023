package nl.roka.adventofcode.aoc2023.day9;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SequenceSolver {
  private static final Logger log = LoggerFactory.getLogger(SequenceSolver.class);

  private final Sequence rootSquence;

  public SequenceSolver(Sequence sequence) {
    rootSquence = sequence;
  }

  public static BigInteger findNext(Sequence sequence) {
    var solver = new SequenceSolver(sequence);
    return solver.solveDiff();
  }

  private BigInteger solveDiff() {
    var diffs = new ArrayList<Sequence>();
    diffs.add(rootSquence);
    var current = rootSquence;

    while (!current.valuesAreEqual()) {
      current = findDiff(current);
      log.debug("rootDiff = {}", current);
      diffs.add(current);
      if (current.size() == 1)
        throw new IllegalStateException("Failed to find common divisor for " + rootSquence);
    }

    Collections.reverse(diffs);
    BigInteger result = BigInteger.ZERO;
    log.debug("Arithmetic d={}: {}", diffs.get(0).lastValueInSequence(), diffs);
    for (int i = 0; i < diffs.size(); i++) {
      result = result.add(diffs.get(i).lastValueInSequence());
    }
    return result;
  }

  private Sequence findDiff(Sequence sequence) {
    List<BigInteger> diffs = new ArrayList<>();
    for (int i = 0; i < sequence.size() - 1; i++) {
      diffs.add(sequence.diff(i, i + 1));
    }
    return Sequence.of(diffs);
  }
}
