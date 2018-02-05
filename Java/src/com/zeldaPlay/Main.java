package com.zeldaPlay;

import java.util.Scanner;
import com.zeldaPlay.utils.*;

public class Main {

  public static Integer getIntInput() {
    Scanner kb = new Scanner(System.in);
    try {
      return kb.nextInt();
    } catch (Exception e) {
      System.out.println("In case you didn't know that stat needs to be an Integer.\nPlease try again.");
      return getIntInput();
      
    }
  }

  public static String getStringInput() {
    Scanner kb = new Scanner(System.in);
    try {
      String input = kb.nextLine();
      return input;
    } catch (Exception e) {
      System.out.println("How did you mess up entering a string?\nTry it again.");
      return getStringInput();
    }
  }

  public static Character makeCharacter(){
    System.out.println("Please enter your name.");
    String name = getStringInput();
    System.out.println("Great! Nice to meet you "+name+"! How strong are you?");
    int str = getIntInput();
    System.out.println(str>15?"Wow! That's pretty strong!":"Oh, I'm guessing you rely on magic or something.");
    System.out.println("How agile are you?");
    int dex = getIntInput();
    System.out.println(dex>15?"Very nice! I'm guessing you can't take a hit though.":"Oh, well, I hope you can take a few hits on the field.");
    System.out.println("Speaking of which, what is your constitution?");
    int con = getIntInput();
    System.out.println(con>15?"You can definitely take a hit!":"Well, try not to get hit too much");
    System.out.println("How smart would you say you are?");
    int intel = getIntInput();
    System.out.println(intel>15?"Oh don't we have a wiz kid over here!":"Eh, intelligence is overrated anyways.");
    System.out.println("What really matters is how sensible you are.");
    int wis = getIntInput();
    System.out.println(wis>15?"You definitely aren't stupid in the streets.":"Maybe you shouldn't do the talking in a party. Don't want to offend anyone.");
    System.out.println("Now, can you lie?");
    int cha = getIntInput();
    System.out.println(cha>15?"Remind me not to let you near my money. I'll never get it back":"Oh, good to know *snickers* sucker.");
    System.out.println("On a scale of 0 to x, what would x be to represent your health and magic? Just give me two numbers I'll figure it out.");
    int hp = getIntInput();
    int mp = getIntInput();
    Character character = new Character(name, "", "Hylian", str, dex, con, intel, wis, cha, hp, mp);
    System.out.println("For now, I'm assuming you're a Hylian, but that can change later");
    System.out.println("Your name is:\t\t\t"+character.getName());
    System.out.println("Your strength is:\t\t"+character.getStr()+"\t\t"+character.getStrBon());
    System.out.println("Your dexterity is:\t\t"+character.getDex()+"\t\t"+character.getDexBon());
    System.out.println("Your constitution is:\t\t"+character.getCon()+"\t\t"+character.getConBon());
    System.out.println("Your intelligence is:\t\t"+character.getInt()+"\t\t"+character.getIntBon());
    System.out.println("Your wisdom is:\t\t\t"+character.getWis()+"\t\t"+character.getWisBon());
    System.out.println("Your charisam is:\t\t"+character.getCha()+"\t\t"+character.getChaBon());
    System.out.println("Your health points are:\t\t"+character.getHealth());
    System.out.println("Your magic points are:\t\t"+character.getMagic());
    return character;
  }

  public static void track(Character character) {
    Boolean keepGoing = true;
    String menu = "\n\n1. \tRoll D4\n2. \tRoll D6\n3. \tRoll D8\n4. \tRoll D10\n5. \tRoll D12\n6. \tRoll D20\n7. \tRoll D100 (Percentage Die)\n8. \tModify Health\n9. \tModify Magic\n10. \tAdd Experience\nq. \tQuit\n";
    System.out.println("Please chose one of the following options. If you would like to quit press \"q\".\n" + menu);
    String choice;
    do {
      choice = getStringInput();
      switch (choice) {
      case "1":
        System.out.println("You rolled a " + Dice.rollDice(4)+menu);
        break;
      case "2":
        System.out.println("You rolled a " + Dice.rollDice(6)+menu);
        break;
      case "3":
        System.out.println("You rolled a " + Dice.rollDice(8)+menu);
        break;
      case "4":
        System.out.println("You rolled a " + Dice.rollDice(10)+menu);
        break;
      case "5":
        System.out.println("You rolled a " + Dice.rollDice(12)+menu);
        break;
      case "6":
        System.out.println("You rolled a " + Dice.rollDice(20)+menu);
        break;
      case "7":
        System.out.println("You rolled a " + Dice.rollDice(100)+menu);
        break;
      case "8": //Do logic for health modification
        break;
      case "9": //Do logic for magic modification
        break;
      case "10": //Do logic for exp addition
        break;
      case "q":
        keepGoing = false;
        break;
      default:
        System.out.println("Can you please enter a valid option?\n" + menu);
      }
    } while (keepGoing);
  }

  public static void main(String[] args) {
    System.out.println("Hello!");
    System.out.println(
        "I'm so glad you decided to use me to help you track you zeldaPlay character!\nThroughout the course of this program, I will ask you several questions and give you several choices.\nPlease follow instructions so that I do not have to get mad at you.\nLet's begin.");
    Character character = makeCharacter();
    System.out.println(
        "Now I will show you a menu of options that you have.\nYou will be able to roll any dice that you want of the polyhedral set.\nYou will also be able to modify your health and magic points as well as gain experience.\nAgain, please try to follow instructions carefully as the GUI has not yet been created.");
    track(character);
    System.out.println("Thank you for using this program "+character.getName()+".\nHave a great day.");
  }

}