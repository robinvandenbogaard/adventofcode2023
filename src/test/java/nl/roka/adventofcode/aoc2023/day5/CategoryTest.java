package nl.roka.adventofcode.aoc2023.day5;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.math.BigInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CategoryTest {

  @ParameterizedTest
  @CsvSource({"80,80", "81,81", "50,50", "51,51", "52,52"})
  void inRange(BigInteger source, BigInteger expected) {
    var category =
        CategoryBuilder.builder()
            .from("x")
            .to("y")
            .addMapping(Mapping.of(80, 80, 2))
            .addMapping(Mapping.of(50, 50, 3))
            .build();

    assertThat(category.getDestination(source)).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({"97", "100", "49", "53"})
  void outOfRange(BigInteger source) {
    var category =
        CategoryBuilder.builder()
            .from("x")
            .to("y")
            .addMapping(Mapping.of(50, 98, 2))
            .addMapping(Mapping.of(52, 50, 3))
            .build();

    assertThat(category.getDestination(source)).isEqualTo(source);
  }

  @ParameterizedTest
  @CsvSource({"49,20", "50,10", "51,22"})
  void favorSmallestSourceRange(BigInteger source, BigInteger expected) {
    var category =
        CategoryBuilder.builder()
            .from("x")
            .to("y")
            .addMapping(Mapping.of(20, 49, 3))
            .addMapping(Mapping.of(10, 50, 1)) // overlap with lower source, order matters
            .build();

    assertThat(category.getDestination(source)).isEqualTo(expected);
  }
}
