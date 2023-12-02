package nl.roka.adventofcode.aoc2023.day2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nl.roka.adventofcode.aoc.Line;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameTest {

  @ParameterizedTest
  @CsvSource(
      delimiterString = "###",
      value = {
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green###1",
        "Game 10: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue###10",
        "Game 100000: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green###100000"
      })
  void idFromLine(Line line, int id) {
    var game = Game.fromLine(line);
    assertThat(game.id()).isEqualTo(id);
  }

  @Test
  void singleSet() {
    Line line = Line.of( "Game 1: 1 red, 2 green, 6 blue");
    var game = Game.fromLine(line);
    assertThat(game.gameSets()).containsExactly(GameSet.of(1,2,6));
  }

  @Test
  void multipleSets() {
    Line line = Line.of( "Game 1: 3 blue, 4 red; 1 red, 6 blue, 2 green; 2 green");
    var game = Game.fromLine(line);
    assertThat(game.gameSets()).containsExactly(GameSet.of(4,0,3), GameSet.of(1,2,6), GameSet.of(0,2,0));
  }

  @Test
  void input_is_possible_if_all_sets_are_less_than_input() {
    var game = new Game(1, List.of(GameSet.of(1, 1, 1), GameSet.of(2, 2, 2)));
    var input = new Input(2, 2, 2);
    assertThat(game.isPossible(input)).isTrue();
  }
}
