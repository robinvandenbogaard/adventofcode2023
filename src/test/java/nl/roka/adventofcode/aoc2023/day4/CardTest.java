package nl.roka.adventofcode.aoc2023.day4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nl.roka.adventofcode.aoc.input.Line;
import org.junit.jupiter.api.Test;

class CardTest {

  @Test
  void toCard() {
    assertThat(Card.toCard(Line.of("Card     1: 1 | 1")).number()).isEqualTo(1);
    assertThat(Card.toCard(Line.of("Card  1000: 1 | 1")).number()).isEqualTo(1000);
    assertThat(Card.toCard(Line.of("Card 12312: 1 | 1")).number()).isEqualTo(12312);
  }

  @Test
  void toCardWinning() {
    assertThat(Card.toCard(Line.of("Card 1:  1  2  3 10| 1")).winning()).contains(1, 2, 3, 10);
  }

  @Test
  void toCardActual() {
    assertThat(Card.toCard(Line.of("Card 1:  1 | 2  3 10 1")).actual()).contains(1, 2, 3, 10);
  }

  @Test
  void countMatches() {
    var card = new Card(1, List.of(1,2,3,4), List.of(3,4));
    assertThat(card.countMatches()).isEqualTo(2);
  }
}
