package com.zeldaPlay.utils;

import com.zeldaPlay.exceptions.*;

import java.util.Scanner;

public class Inputs{

  private static Scanner kb = new Scanner(System.in);

  public static int getIntInput(boolean stat) {
    try {
      int input;
      input = kb.nextInt();
      if (input == 0) {
        throw new IntZeroException("Okay, smartie-pants, you can't enter 0 for a stat...\nOr anything else for that matter!");
      } else if (input > 630) {
        throw new HighInputException("You may not enter a number larger than 630, please follow this rule.");
      } else if (input < 0) {
        throw new NegativeIntException("None of your inputs can be negative.");
      } else if (stat && input > 24) {
        throw new HighStatException("Your starting stats cannot be greater than 24.");
      }
      return input;
    } catch(RuntimeException re) {
      System.out.println("Runtime Exception:"+re.getLocalizedMessage());
      return 0;
    }catch (Exception e) {
      System.out.println(e.getMessage());
      return getIntInput(stat);
    }
  }

  public static String getStringInput() {
    try {
      String input = kb.nextLine();
      if (input.isEmpty()) {
        throw new EmptyStringException("Please, I would like to know your name.");
      }
      return input;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return getStringInput();
    }
  }

  public static char getCharInput(){
    try{
      String input = kb.next();
      if(input.length() > 1){
        throw new BadCharacterException("You can only enter a single character for the menu. Please don't o more than that.");
      }
      return input.charAt(0);
    }catch(Exception e){
      System.out.println(e.getMessage());
      return getCharInput();
    }
  }
}