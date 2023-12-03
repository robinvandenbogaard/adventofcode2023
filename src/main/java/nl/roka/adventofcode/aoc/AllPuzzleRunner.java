package nl.roka.adventofcode.aoc;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.stream.Stream;
import nl.roka.adventofcode.aoc2023.AbstractDayPuzzle;
import org.reflections.Reflections;

public class AllPuzzleRunner {

  public static void main(String[] args) {

    System.err.printf(
        "%nWarming up the jvm by solving all puzzles %d times. Then time and solve the puzzle and print the results.%n%n",
        Runner.WARMUP_REPETITIONS);

    getAbstractDayPuzzles()
        .forEach(
            puzzle -> {
              Runner.warmup(puzzle);
              Runner.run(puzzle);
            });
  }

  private static Stream<AbstractDayPuzzle> getAbstractDayPuzzles() {
    return new Reflections("nl.roka.adventofcode.aoc2023")
        .getSubTypesOf(AbstractDayPuzzle.class).stream()
            .sorted(Comparator.comparing(Class::getSimpleName))
            .map(
                typeClass -> {
                  try {
                    return typeClass.getConstructor().newInstance();
                  } catch (NoSuchMethodException
                      | InstantiationException
                      | IllegalAccessException
                      | InvocationTargetException e) {
                    throw new RuntimeException(e);
                  }
                });
  }
}
