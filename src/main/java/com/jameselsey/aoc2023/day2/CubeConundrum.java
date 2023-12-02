package com.jameselsey.aoc2023.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2023/day/2
 * <p>
 * On this one, my initial thinking is that I first need to parse the file and split it several
 * times by the ; and : characters, if I can get this into a collection of objects, I should be able
 * to map/reduce it to get the answer.
 */
public class CubeConundrum {

  public static void main(String[] args) {
    CubeConundrum cc = new CubeConundrum();

    try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/day2/input.txt"))) {

      List<String> linesList = lines.toList();

      Optional<Integer> result = cc.process(linesList.stream());
      System.out.println("part 1 result: " + result.get());

      Optional<Integer> result2 = cc.process2(linesList.stream());
      System.out.println("part 2 result: " + result2.get());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Optional<Integer> process2(Stream<String> lines) {
    return lines
        .map(CubeConundrum::mapLine)
        .map(Game::power)
        .reduce(Integer::sum);
  }


  public Optional<Integer> process(Stream<String> lines) {
    return lines
        .map(CubeConundrum::mapLine)
        .filter(Game::isValid)
        .map(g -> g.gameNumber)
        .reduce(Integer::sum);
  }

  private static Game mapLine(String l) {
    // first split will be the game ID, remaining splits will be the game sets
    String[] lineSections = l.split("[;:]");

    int gameNumber = 0;
    Matcher m = Pattern.compile("\\d+").matcher(lineSections[0]);
    if (m.find()) {
      gameNumber = Integer.parseInt(m.group());
    }

    Game g = new Game();
    g.gameNumber = gameNumber;

    for (int i = 1; i < lineSections.length; i++) {
      String[] gameSet = lineSections[i].split(",");
      GameSet gs = new GameSet(0, 0, 0);
      for (int j = 0; j < gameSet.length; j++) {
        String[] gameSetColour = gameSet[j].split(" ");
        switch (gameSetColour[2]) {
          case "red":
            gs.redCount = Integer.parseInt(gameSetColour[1]);
            break;
          case "blue":
            gs.blueCount = Integer.parseInt(gameSetColour[1]);
            break;
          case "green":
            gs.greenCount = Integer.parseInt(gameSetColour[1]);
            break;
        }
      }
      g.gameSets.add(gs);
    }

    return g;
  }


}
