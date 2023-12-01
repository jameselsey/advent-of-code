package com.jameselsey.aoc2023.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2023/day/1
 */
public class TrebuchetPartTwo {

  public static void main(String[] args) {

    TrebuchetPartTwo t = new TrebuchetPartTwo();

    // Stream on lines of a file was introduced in java 11, this is quite a nice way to get from a file
    // straight to a stream without having to worry about opening/closing. It also lazily loads lines so is
    // efficient with memory
    try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/day1/input1.txt"))) {
      Optional<Integer> result = t.process(lines);
      System.out.println(result.get());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Optional<Integer> process(Stream<String> lines) {
    // are streams cheating? I don't know, it's a nice way to do it though
    //
    // I wanted to process each line individually, then sum up the results.
    return lines.map(this::calibrate).reduce(Integer::sum);
  }

  public int calibrate(String input) {

    int left = 0;
    int right = 0;

    left = getFirstNumber(input);
    right = getLastNumber(new StringBuilder(input).reverse().toString());

    var result = (left * 10) + right;

    System.out.println(
        "input is %s and left %d right %d result %d".formatted(input, left, right, result));

    return result;
  }

  private int getFirstNumber(String input) {
    StringBuilder sb = new StringBuilder("");
    int theNumber = 0;
    for (int i = 0; i < input.length(); i++) {

      char c = input.charAt(i);

      if (Character.isDigit(c)) {
        theNumber = Character.getNumericValue(c);
        break;
      }

      sb.append(c);

      OptionalInt potentialNumber = getNumber(sb.toString());
      if (potentialNumber.isPresent()) {
        theNumber = potentialNumber.getAsInt();
        break;
      }

    }
    return theNumber;
  }

  private int getLastNumber(String input) {
    StringBuilder sb = new StringBuilder("");
    int theNumber = 0;

    for (int i = 0; i < input.length(); i++) {

      char c = input.charAt(i);

      if (Character.isDigit(c)) {
        theNumber = Character.getNumericValue(c);
        break;
      }

      // insert at the start of the string, even though we're walking backwards, we want to prepend so
      // the string remains readable, like two instead of owt
      sb.insert(0, c);

      OptionalInt potentialNumber = getNumber(sb.toString());
      if (potentialNumber.isPresent()) {
        theNumber = potentialNumber.getAsInt();
        break;
      }

    }
    return theNumber;
  }


  private OptionalInt getNumber(String text) {
    if (text.contains("one")) {
      return OptionalInt.of(1);
    } else if (text.contains("two")) {
      return OptionalInt.of(2);
    } else if (text.contains("three")) {
      return OptionalInt.of(3);
    } else if (text.contains("four")) {
      return OptionalInt.of(4);
    } else if (text.contains("five")) {
      return OptionalInt.of(5);
    } else if (text.contains("six")) {
      return OptionalInt.of(6);
    } else if (text.contains("seven")) {
      return OptionalInt.of(7);
    } else if (text.contains("eight")) {
      return OptionalInt.of(8);
    } else if (text.contains("nine")) {
      return OptionalInt.of(9);
    } else {
      return OptionalInt.empty();
    }
  }
}
