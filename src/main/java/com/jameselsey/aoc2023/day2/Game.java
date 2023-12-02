package com.jameselsey.aoc2023.day2;

import java.util.HashSet;
import java.util.Set;

public class Game {

  int gameNumber;
  Set<GameSet> gameSets = new HashSet<GameSet>();

  boolean isValid() {
    // if none of the game sets are above the threshold, then it must be valid
    return gameSets.stream()
        .noneMatch(g -> g.redCount > 12 || g.blueCount > 14 || g.greenCount > 13);
  }

  public int power() {

    // some times a good old fashioned loop is the best way to do it
    int redCount = 0;
    int blueCount = 0;
    int greenCount = 0;
    for (GameSet ge : gameSets) {

      if (ge.redCount > redCount) {
        redCount = ge.redCount;
      }
      if (ge.blueCount > blueCount) {
        blueCount = ge.blueCount;
      }
      if (ge.greenCount > greenCount) {
        greenCount = ge.greenCount;
      }
    }

    return redCount * blueCount * greenCount;
  }
}
