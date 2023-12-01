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
public class Trebuchet {

  public static void main(String[] args) {

    Trebuchet t = new Trebuchet();

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

  private int calibrate(String input) {

    OptionalInt leftDigit = input.chars()
        .mapToObj(c -> (char) c)
        .filter(Character::isDigit)
        .mapToInt(Character::getNumericValue)
        .peek(System.out::println)
        .findFirst();

    // had to pass this in as a string builder as reversing on the stream didn't seem to work, it would give the first.
    OptionalInt rightDigit = new StringBuilder(input).reverse().chars()
        .mapToObj(c -> (char) c)
        .filter(Character::isDigit)
        .mapToInt(Character::getNumericValue)
        .peek(System.out::println)
        .findFirst();

    var result = 0;
    if (leftDigit.isPresent() && rightDigit.isPresent()) {
      result = (leftDigit.getAsInt() * 10) + rightDigit.getAsInt();
    }
    System.out.println(
        "input is [%s] leftDigit is [%s] rightDigit is [%s], combined is [%s]".formatted(input,
            leftDigit.getAsInt(), rightDigit.getAsInt(), result));

    return result;
  }
}
