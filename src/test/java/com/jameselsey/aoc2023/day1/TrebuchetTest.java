package com.jameselsey.aoc2023.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class TrebuchetTest {

  @Test
  void calculate() {
    Trebuchet t = new Trebuchet();

    Optional<Integer> result = t.process(
        Stream.of("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"));

    assertEquals(142, result.get());
  }
}
