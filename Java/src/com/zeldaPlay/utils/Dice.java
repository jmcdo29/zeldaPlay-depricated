package com.zeldaPlay.utils;

import java.util.*;
import static java.lang.Math.toIntExact;

public class Dice{

  public static Integer rollDice(int sides){
    Integer result;
    result = toIntExact(Math.round(Math.random() * sides) + 1);
    return result;
  }

  public static Integer rollDice(int sides, int bonus){
    Integer result;
    result = toIntExact(Math.round(Math.random() * sides) + 1 + bonus);
    return result;
  }
}