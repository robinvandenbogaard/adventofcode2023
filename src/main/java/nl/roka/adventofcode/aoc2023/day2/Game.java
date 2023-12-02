package nl.roka.adventofcode.aoc2023.day2;

import java.util.List;
import nl.roka.adventofcode.aoc.Line;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

record Game(int id, List<GameSet> gameSets) {

  private static final Logger log = LoggerFactory.getLogger(Game.class);

  public boolean isPossible(Input input) {
    return gameSets.stream().allMatch(gameSet -> gameSet.lessThan(input));
  }

  public static Game fromLine(Line line) {
    log.info("line: {}", line);
    int semicolonIndex = line.text().indexOf(":");
    int id = Integer.parseInt(line.text().substring(5, semicolonIndex));
    List<GameSet> gameSets = GameSet.toSets(line.text().substring(semicolonIndex+1));
    return new Game(id, gameSets);
  }
}
