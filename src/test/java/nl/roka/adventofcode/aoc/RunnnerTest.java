package nl.roka.adventofcode.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RunnnerTest {
  @Test
  void fillDaysWithLeadingZerosUnderTen() {
    DayPuzzle puzzle = createPuzzle(0);
    assertThat(Runnner.run(puzzle))
        .isEqualTo("Day 000: [silver='my silver answer', gold='my gold answer']");
  }

  @Test
  void dontFillDaysWithLeadingZerosTenAndUp() {
    DayPuzzle puzzle = createPuzzle(10);
    assertThat(Runnner.run(puzzle))
        .isEqualTo("Day 010: [silver='my silver answer', gold='my gold answer']");
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
