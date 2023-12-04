package nl.roka.adventofcode.aoc2023.day2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameSetTest {

  @Test
  void pow() {
    assertThat(GameSet.of(1, 1, 1).pow()).isEqualTo(1);
    assertThat(GameSet.of(4, 2, 6).pow()).isEqualTo(48);
    assertThat(GameSet.of(1, 3, 4).pow()).isEqualTo(12);
    assertThat(GameSet.of(20, 13, 6).pow()).isEqualTo(1560);
    assertThat(GameSet.of(14, 3, 15).pow()).isEqualTo(630);
    assertThat(GameSet.of(6, 3, 2).pow()).isEqualTo(36);
  }
}
