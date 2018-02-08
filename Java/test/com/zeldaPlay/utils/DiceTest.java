package com.zeldaPlay.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;

public class DiceTest {

  private void testRoll(int sides){
    for(int i = 0; i < sides * 2; i++){
      assertTrue(Dice.rollDice(sides)<=sides);
    }
  }

  private void testRollWithBon(int sides, int bonus){
    for(int i = 0; i < sides * 2; i++){
      assertTrue(Dice.rollDice(sides,bonus)<=sides+bonus);
    }
  }
  @Test
  public void doRolls(){
    testRoll(4);
    testRoll(6);
    testRoll(8);
    testRoll(10);
    testRoll(12);
    testRoll(20);
    testRoll(100);
    testRollWithBon(4,7);
    testRollWithBon(6,7);
    testRollWithBon(8,7);
    testRollWithBon(10,7);
    testRollWithBon(12,7);
    testRollWithBon(20,7);
    testRollWithBon(100,7);
  }
}
