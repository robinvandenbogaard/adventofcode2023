package nl.roka.adventofcode.aoc2023.day7;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandComparatorTest {

  private static final Hand FIVEOFKIND = new Hand(null, null, CardType.FiveOfKind);
  private static final Hand FOUROFKIND = new Hand(null, null, CardType.FourOfKind);
  private static final Hand FULLHOUSE = new Hand(null, null, CardType.FullHouse);
  private static final Hand THREEOFKIND = new Hand(null, null, CardType.ThreeOfKind);
  private static final Hand TWOPAIR = new Hand(null, null, CardType.TwoPair);
  private static final Hand ONEPAIR = new Hand(null, null, CardType.OnePair);
  private static final Hand HIGHCARD = new Hand("AAAAA", null, CardType.HighCard);

  @Test
  void compare() {
    assertThat(HandComparator.compare(HIGHCARD, HIGHCARD)).isEqualTo(0);
    assertThat(HandComparator.compare(FIVEOFKIND, FOUROFKIND)).isEqualTo(1);
    assertThat(HandComparator.compare(THREEOFKIND, FULLHOUSE)).isEqualTo(-1);
  }

  @Test
  void sort_lowest_rank_first_high_rank_last() {
    var sorted = Stream.of(TWOPAIR, ONEPAIR).sorted(HandComparator::compare).toList();
    assertThat(sorted).containsExactly(ONEPAIR, TWOPAIR);
  }

  @Test
  void second_rank_compare_when_type_is_equal() {
    var rank0 = new Hand("AAAA2", null, CardType.FourOfKind);
    var rank1 = new Hand("AAAA3", null, CardType.FourOfKind);
    assertThat(HandComparator.compare(rank1, rank0)).isEqualTo(1);
    assertThat(HandComparator.compare(rank0, rank1)).isEqualTo(-1);
  }

  @Test
  void joker() {
    var rank0 = new Hand("AAAAJ", null, CardType.FourOfKind);
    var rank1 = new Hand("AAAA2", null, CardType.FourOfKind);
    assertThat(HandComparator.compareWithJoker(rank1, rank0)).isEqualTo(1);
    assertThat(HandComparator.compareWithJoker(rank0, rank1)).isEqualTo(-1);
  }

  @Test
  void joker_card_type_prefails() {
    var rank0 = new Hand("JJAA3", null, CardType.TwoPair);
    var rank1 = new Hand("JJJAA", null, CardType.ThreeOfKind);
    assertThat(HandComparator.compareWithJoker(rank1, rank0)).isEqualTo(1);
    assertThat(HandComparator.compareWithJoker(rank0, rank1)).isEqualTo(-1);
  }

  @Test
  @DisplayName("JKKK2 is weaker than QQQQ2 because J is weaker than Q.")
  void exampleJokerWeakness() {
    var rank0 = new Hand("JKKK2", null, CardType.FourOfKind);
    var rank1 = new Hand("QQQQ2", null, CardType.FourOfKind);
    assertThat(HandComparator.compareWithJoker(rank1, rank0)).isEqualTo(1);
    assertThat(HandComparator.compareWithJoker(rank0, rank1)).isEqualTo(-1);
  }
}
