package com.zeldaPlay.utils;

import com.zeldaPlay.exceptions.*;


public class Inputs{

  private static boolean containsWhiteSpace(String input){
    for(int i = 0; i < input.length(); i++){
      if(Character.isAlphabetic(input.charAt(i))){
        break;
      }else if(Character.isWhitespace(input.charAt(i))){
        return true;
      }
    }
    return false;
  }

  public static boolean verifyIntInput(String input, boolean stat) {
    try {
      int intIn = Integer.valueOf(input);
      if (intIn == 0) {
        throw new IntZeroException("Okay, smartie-pants, you can't enter 0 for a stat...\nOr anything else for that matter!");
      } else if (intIn > 630) {
        throw new HighInputException("You may not enter a number larger than 630, please follow this rule.");
      } else if (intIn < 0) {
        throw new NegativeIntException("None of your inputs can be negative.");
      } else if (stat && intIn > 24) {
        throw new HighStatException("Your starting stats cannot be greater than 24.");
      }
      return true;
    }catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  public static boolean verifyStringInput(String input) {
    try {
      if (input.isEmpty() || containsWhiteSpace(input)) {
        throw new EmptyStringException("Please, I would like to know your name.");
      }
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  public static boolean verifyCharInput(String input){
    try{
      if(input.length() > 1){
        throw new BadCharacterException("You can only enter a single character for the menu. Please don't o more than that.");
      }
      return true;
    }catch(Exception e){
      System.out.println(e.getMessage());
      return false;
    }
  }
}