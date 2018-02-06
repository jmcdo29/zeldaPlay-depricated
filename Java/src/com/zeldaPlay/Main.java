package com.zeldaPlay;

import java.util.Scanner;
import com.zeldaPlay.utils.*;
import com.zeldaPlay.exceptions.*;

public class Main {

  public static Scanner kb = new Scanner(System.in);

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

  public static ZeldaPlayer makeZeldaPlayer() {
    System.out.println("Please enter your name.");
    String name = getStringInput();
    System.out.println("Great! Nice to meet you " + name + "! How strong are you?");
    int str = getIntInput(true);
    System.out.println(str > 15 ? "Wow! That's pretty strong!" : "Oh, I'm guessing you rely on magic or something.");
    System.out.println("How agile are you?");
    int dex = getIntInput(true);
    System.out.println(dex > 15 ? "Very nice! I'm guessing you can't take a hit though."
        : "Oh, well, I hope you can take a few hits on the field.");
    System.out.println("Speaking of which, what is your constitution?");
    int con = getIntInput(true);
    System.out.println(con > 15 ? "You can definitely take a hit!" : "Well, try not to get hit too much");
    System.out.println("How smart would you say you are?");
    int intel = getIntInput(true);
    System.out.println(intel > 15 ? "Oh don't we have a wiz kid over here!" : "Eh, intelligence is overrated anyways.");
    System.out.println("What really matters is how sensible you are.");
    int wis = getIntInput(true);
    System.out.println(wis > 15 ? "You definitely aren't stupid in the streets."
        : "Maybe you shouldn't do the talking in a party. Don't want to offend anyone.");
    System.out.println("Now, can you lie?");
    int cha = getIntInput(true);
    System.out.println(cha > 15 ? "Remind me not to let you near my money. I'll never get it back"
        : "Oh, good to know *snickers* sucker.");

    ZeldaPlayer zeldaPlayer = new ZeldaPlayer(name, "", "Hylian", str, dex, con, intel, wis, cha);
    System.out.println("For now, I'm assuming you're a Hylian, but that can change later");
    System.out.println("Your name is:\t\t\t\t" + zeldaPlayer.getName());
    System.out.println("Your strength is:\t\t\t" + zeldaPlayer.getStr() + "\t\t" + zeldaPlayer.getStrBon());
    System.out.println("Your dexterity is:\t\t\t" + zeldaPlayer.getDex() + "\t\t" + zeldaPlayer.getDexBon());
    System.out.println("Your constitution is:\t\t" + zeldaPlayer.getCon() + "\t\t" + zeldaPlayer.getConBon());
    System.out.println("Your intelligence is:\t\t" + zeldaPlayer.getInt() + "\t\t" + zeldaPlayer.getIntBon());
    System.out.println("Your wisdom is:\t\t\t\t" + zeldaPlayer.getWis() + "\t\t" + zeldaPlayer.getWisBon());
    System.out.println("Your charisma is:\t\t\t" + zeldaPlayer.getCha() + "\t\t" + zeldaPlayer.getChaBon());
    System.out.println("Your health points are:\t\t" + zeldaPlayer.getHealth());
    System.out.println("Your magic points are:\t\t" + zeldaPlayer.getMagic());
    return zeldaPlayer;
  }

  public static void healthMenu(ZeldaPlayer zeldaPlayer) {
    boolean keepShowing;
    String menu = "Chose the correct option:\n1. \tRestore Health\n2. \tLose Health\nq. \tGo Back";
    System.out.println("So you need to make a change to your health?\n" + menu);
    char input;
    do {
      if (zeldaPlayer.getDead()) {
        System.out.println(
            "All you can do while dead is wait to be revived. For your sake, I hope your party memebrs are helpful, and I hope you're not the healer.");
        System.out.println(menu);
      }
      if (zeldaPlayer.getDying() && !zeldaPlayer.getDead()) {
        System.out.println(
            "All you can do while unconcious is take damage and wait for your allies to heal you. Hope you weren't the healer!");
        System.out.println(menu);
      }
      do {
        input = getCharInput();
        keepShowing = false;
        switch (input) {
        case '1':
          System.out.println("Enter the amount of hit points you restored. And don't try to go over your max!");
          int restore;
          restore = getIntInput(false);
          if (zeldaPlayer.getHealth() + restore > zeldaPlayer.getMaxHP()) {
            System.out.println("I said DON'T try to go over your max, you idiot. I'm setting your hp to max.");
            zeldaPlayer.setHP(zeldaPlayer.getMaxHP());
          } else {
            zeldaPlayer.changeHP(restore);
            System.out.println("Your health points are now at " + zeldaPlayer.getHealth());
          }
          if (zeldaPlayer.getHealth() <= 0 && zeldaPlayer.getDead()) {
            zeldaPlayer.setDead(false);
            zeldaPlayer.setDying(true);
            System.out.println("You are no longer dead, but you are still unconcious. Heal up some more.");
          }
          if (zeldaPlayer.getHealth() > 0 && (zeldaPlayer.getDying() || zeldaPlayer.getDead())) {
            zeldaPlayer.setDead(false);
            zeldaPlayer.setDying(false);
            System.out.println("You are no longer unconcious. Congratulations.");
          }
          break;
        case '2':
          int dmg;
          System.out.println("So you took some damage, huh? Well, tell me how much you took.");
          dmg = getIntInput(false);
          if (zeldaPlayer.getHealth() - dmg <= 0) {
            if (zeldaPlayer.getHealth() - dmg <= -10) {
              System.out.println(
                  "You have died. You cannot do anything else until you are revived by your party members. Sucks to be you.");
              zeldaPlayer.changeHP(-(zeldaPlayer.getHealth() + 10));
              zeldaPlayer.setDead(true);
            } else {
              System.out.println("Ouch, looks like you're unconcious. You must wait for a party member to heal you.");
              zeldaPlayer.changeHP(-dmg);
              zeldaPlayer.setDying(true);
            }
          } else {
            System.out.println(dmg > zeldaPlayer.getHealth() / 4 ? "Ouch, that looks like it hurt!"
                : "Shrug it off champ! You can do this!");
            zeldaPlayer.changeHP(-dmg);
          }
          System.out.println("After taking damage, your hit points are now at " + zeldaPlayer.getHealth());
          break;
        case 'q':
          System.out.println("Really? Gonna waste my time like that?");
          break;
        default:
          System.out.println("How did you manage to mess that up? Try again.\n" + menu);
          keepShowing = true;
          break;
        }
      } while (keepShowing);
    } while (zeldaPlayer.getDead() || zeldaPlayer.getDying());
  }

  public static void magicMenu(ZeldaPlayer zeldaPlayer) {

  }

  public static void expMenu(ZeldaPlayer zeldaPlayer) {

  }

  public static void track(ZeldaPlayer zeldaPlayer) {
    boolean keepGoing = true;
    String menu = "\n\n1. \tRoll D4\n2. \tRoll D6\n3. \tRoll D8\n4. \tRoll D10\n5. \tRoll D12\n6. \tRoll D20\n7. \tRoll D100 (Percentage Die)\n8. \tModify Health\n9. \tModify Magic\ne. \tAdd Experience\ns. \tShow Stats\nq. \tQuit\n";
    System.out.println("Please chose one of the following options. If you would like to quit press \"q\".\n" + menu);
    char choice;
    do {
      choice = getCharInput();
      switch (choice) {
      case '1':
        System.out.println("You rolled a " + Dice.rollDice(4) + menu);
        break;
      case '2':
        System.out.println("You rolled a " + Dice.rollDice(6) + menu);
        break;
      case '3':
        System.out.println("You rolled a " + Dice.rollDice(8) + menu);
        break;
      case '4':
        System.out.println("You rolled a " + Dice.rollDice(10) + menu);
        break;
      case '5':
        System.out.println("You rolled a " + Dice.rollDice(12) + menu);
        break;
      case '6':
        System.out.println("You rolled a " + Dice.rollDice(20) + menu);
        break;
      case '7':
        System.out.println("You rolled a " + Dice.rollDice(100) + menu);
        break;
      case '8':
        healthMenu(zeldaPlayer);
        System.out.println(menu);
        break;
      case '9':
        magicMenu(zeldaPlayer);
        System.out.println(menu);
        break;
      case 'e':
        expMenu(zeldaPlayer);
        System.out.println(menu);
        break;
      case 's':
        zeldaPlayer.printStats();
        System.out.println(menu);
        break;
      case 'q':
        keepGoing = false;
        break;
      default:
        System.out.println("Can you please enter a valid option?\n" + menu);
      }
    } while (keepGoing);
  }

  public static void main(String[] args) {
    try {
      System.out.println("Hello!");
      System.out.println(
          "I'm so glad you decided to use me to help you track you zeldaPlay charcater!\nThroughout the course of this program, I will ask you several questions and give you several choices.\nPlease follow instructions so that I do not have to get mad at you.\nLet's begin.");
      ZeldaPlayer zeldaPlayer = makeZeldaPlayer();
      System.out.println(
          "Now I will show you a menu of options that you have.\nYou will be able to roll any dice that you want of the polyhedral set.\nYou will also be able to modify your health and magic points as well as gain experience.\nAgain, please try to follow instructions carefully as the GUI has not yet been created.");
      track(zeldaPlayer);
      System.out.println("Thank you for using this program " + zeldaPlayer.getName() + ".\nHave a great day.");
      kb.close();
    } catch (Exception e) {
      System.err.println(e.getMessage() + "\n" + e.getCause());
    }
  }

}