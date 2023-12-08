package nl.roka.adventofcode.aoc2023.day8;

import java.util.ArrayList;
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

  public long calculateUsingLcm(Maps maps) {
    var lengths = calcLengths(maps);
    return lcm(lengths);
  }

  private List<Long> calcLengths(Maps maps) {
    List<Long> result = new ArrayList<>();

    while (!queue.isEmpty()) {
      result.add(getLength(queue.pop(), maps));
    }
    return result;
  }

  private Long getLength(Path pop, Maps maps) {
    var current = pop;
    var steps = 0L;
    while (!current.endsWithZ()) {
      steps++;
      current =
          switch (maps.next()) {
            case 'L' -> maps.get(current).left();
            case 'R' -> maps.get(current).right();
            default -> throw new IllegalStateException("unknown char");
          };
    }
    return steps;
  }

  private static long gcd(long x, long y) {
    return (y == 0L) ? x : gcd(y, x % y);
  }

  public static long lcm(List<Long> numbers) {
    return numbers.stream().reduce(1L, (x, y) -> x * (y / gcd(x, y)));
  }
}
