package nl.roka.adventofcode.aoc2023.day8;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

class PathGroup {
  private final ConcurrentLinkedDeque<Path> queue;

  public PathGroup(List<Path> startingWithA) {
    this.queue = new ConcurrentLinkedDeque<>(startingWithA);
  }

  public boolean notAllEndWithZ() {
    return !queue.stream().allMatch(Path::endsWithZ);
  }

  public void step(Maps maps) {
    var direction = maps.next();
    for (int i = 0; i < queue.size(); i++) {
      var current = maps.get(queue.pop());

      var next =
          switch (direction) {
            case 'L' -> current.left();
            case 'R' -> current.right();
            default -> throw new IllegalStateException("unknown char");
          };

      queue.addLast(next);
    }
  }
}
