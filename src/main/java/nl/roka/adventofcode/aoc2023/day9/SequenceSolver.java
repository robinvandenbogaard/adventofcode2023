package nl.roka.adventofcode.aoc2023.day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SequenceSolver {
  private static final Logger log = LoggerFactory.getLogger(SequenceSolver.class);

  private final Sequence rootSquence;
  private ArrayList<Sequence> diffs;

  public SequenceSolver(Sequence sequence) {
    rootSquence = sequence;
  }

  public static long findNext(Sequence sequence) {
    var solver = new SequenceSolver(sequence);

    return solver.solve();
  }

  private long solve() {
    diffs = new ArrayList<>();
    diffs.add(rootSquence);
    var current = rootSquence;

    while (!current.valuesAreEqual()) {
      current = findDiff(current);
      log.debug("rootDiff = {}", current);
      diffs.add(current);
    }

    Collections.reverse(diffs);
    log.debug("diffs: {}", diffs);

    long result = 0;
    for (int i = 0; i < diffs.size(); i++) {
      result += diffs.get(i).lastValueInSequence();
    }

    return result;
  }

  private Sequence findDiff(Sequence sequence) {
    List<Long> diffs = new ArrayList<>();
    for (int i = 0; i < sequence.size() - 1; i++) {
      diffs.add(sequence.diff(i, i + 1));
    }

    return Sequence.of(diffs);
  }
}
