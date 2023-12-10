package nl.roka.adventofcode.aoc2023.day10;

import java.util.Arrays;
import nl.roka.adventofcode.aoc.input.Grid;
import nl.roka.adventofcode.aoc.input.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pipes {

  private static final Logger log = LoggerFactory.getLogger(Pipes.class);
  private final Grid grid;
  private final Point start;
  private final Pipe startingPipe;

  public Pipes(Grid grid) {
    this.grid = grid;
    this.start = grid.findSymbol("S");
    this.startingPipe = determinePipe(start);
    grid.set(start, startingPipe.type().symbol());
  }

  private Pipe determinePipe(Point start) {
    var type =
        Arrays.stream(Type.values()).filter(t -> t.fitsFor(grid, start)).findFirst().orElseThrow();
    return new Pipe(start, type);
  }

  public int calcSteps() {
    int steps = 0;
    var currentPipe = startingPipe;
    var entrance = startingPipe.type().backwards();
    do {
      var step = currentPipe.stepForward(grid, entrance);
      currentPipe = step.toPipe();
      steps++;
      entrance = step.enteringAt();
      log.debug("Step {}: {}", steps, step);
    } while (!currentPipe.equals(startingPipe));

    return Math.round(steps / 2f);
  }
}
