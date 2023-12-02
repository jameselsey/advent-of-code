package com.jameselsey.aoc2023.day2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class CubeConundrumTest {


  @Test
  void testIsValid(){
    Game g1 = new Game();
    g1.gameNumber = 1;
    g1.gameSets = Set.of(
        new GameSet(4,3,0),
        new GameSet(1,6,2),
        new GameSet(0,0,2)
        );
    assertTrue(g1.isValid());

    Game g2 = new Game();
    g2.gameNumber = 2;
    g2.gameSets = Set.of(
        new GameSet(0,1,2),
        new GameSet(1,4,3),
        new GameSet(0,1,1)
    );
    assertTrue(g2.isValid());

    Game g3 = new Game();
    g3.gameNumber = 3;
    g3.gameSets = Set.of(
        new GameSet(20,6,8),
        new GameSet(4,5,13),
        new GameSet(1,0,5)
    );
    assertFalse(g3.isValid());

    Game g4 = new Game();
    g4.gameNumber = 4;
    g4.gameSets = Set.of(
        new GameSet(3,6,1),
        new GameSet(6,0,3),
        new GameSet(14,15,3)
    );
    assertFalse(g4.isValid());

    Game g5 = new Game();
    g5.gameNumber = 5;
    g5.gameSets = Set.of(
        new GameSet(6,1,3),
        new GameSet(1,2,2)
    );
    assertTrue(g5.isValid());
  }

  @Test
  void testProcess(){
    CubeConundrum cc = new CubeConundrum();

    Optional<Integer> result = cc.process(
        Stream.of(
              "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                      "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                      "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                      "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                      "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        ));

    assertEquals(8, result.get());
  }

  @Test
  void testPower(){
    Game g1 = new Game();
    g1.gameNumber = 1;
    g1.gameSets = Set.of(
        new GameSet(4,3,0),
        new GameSet(1,6,2),
        new GameSet(0,0,2)
    );
    assertEquals(48, g1.power());

    Game g2 = new Game();
    g2.gameNumber = 2;
    g2.gameSets = Set.of(
        new GameSet(0,1,2),
        new GameSet(1,4,3),
        new GameSet(0,1,1)
    );
    assertEquals(12, g2.power());

    Game g3 = new Game();
    g3.gameNumber = 3;
    g3.gameSets = Set.of(
        new GameSet(20,6,8),
        new GameSet(4,5,13),
        new GameSet(1,0,5)
    );
    assertEquals(1560, g3.power());

    Game g4 = new Game();
    g4.gameNumber = 4;
    g4.gameSets = Set.of(
        new GameSet(3,6,1),
        new GameSet(6,0,3),
        new GameSet(14,15,3)
    );
    assertEquals(630, g4.power());

    Game g5 = new Game();
    g5.gameNumber = 5;
    g5.gameSets = Set.of(
        new GameSet(6,1,3),
        new GameSet(1,2,2)
    );
    assertEquals(36, g5.power());
  }

  @Test
  void testProcess2(){
    CubeConundrum cc = new CubeConundrum();

    Optional<Integer> result = cc.process2(
        Stream.of(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        ));

    assertEquals(2286, result.get());
  }
}
