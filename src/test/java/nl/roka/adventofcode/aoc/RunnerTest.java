package nl.roka.adventofcode.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RunnerTest {
  @Test
  void fillDaysWithLeadingZerosUnderTen() {
    DayPuzzle puzzle = createPuzzle(0);
    assertThat(Runner.run(puzzle)).contains("Day 000:");
  }

  @Test
  void dontFillDaysWithLeadingZerosTenAndUp() {
    DayPuzzle puzzle = createPuzzle(10);
    assertThat(Runner.run(puzzle)).contains("Day 010:");
  }

  @Test
  void ouputContainsSilverAnswer() {
    DayPuzzle puzzle = createPuzzle(1);
    assertThat(Runner.run(puzzle)).contains("my silver answer");
  }

  @Test
  void ouputContainsGoldAnswer() {
    DayPuzzle puzzle = createPuzzle(1);
    assertThat(Runner.run(puzzle)).contains("my gold answer");
  }

  private DayPuzzle createPuzzle(int day) {
    return new DayPuzzle() {
      @Override
      public Answer runSilver() {
        return Answer.of("my silver answer");
      }

      @Override
      public Answer runGold() {
        return Answer.of("my gold answer");
      }

      @Override
      public int dayNumber() {
        return day;
      }
    };
  }
}
