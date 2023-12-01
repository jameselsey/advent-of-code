package com.jameselsey.aoc2023.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class TrebuchetPartTwoTest {


  @Test
  void calibrate(){
    TrebuchetPartTwo t = new TrebuchetPartTwo();
    assertEquals(29, t.calibrate("two1nine"));
    assertEquals(83, t.calibrate("eightwothree"));
    assertEquals(13, t.calibrate("abcone2threexyz"));
    assertEquals(24, t.calibrate("xtwone3four"));
    assertEquals(42, t.calibrate("4nineeightseven2"));
    assertEquals(14, t.calibrate("zoneight234"));
    assertEquals(76, t.calibrate("7pqrstsixteen"));
  }

  @Test
  void calculate() {
    TrebuchetPartTwo t = new TrebuchetPartTwo();

    Optional<Integer> result = t.process(
        Stream.of(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen"

        ));

    assertEquals(281, result.get());
  }
}
