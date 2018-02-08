package com.zeldaPlay.utils;

import com.sun.istack.internal.NotNull;
import com.zeldaPlay.player.*;

import java.util.Scanner;

public class Menus{

  private static final Scanner kb = new Scanner(System.in);

  private static void healthMenu(@NotNull ZeldaPlayer zeldaPlayer) {
    boolean keepShowing;
    String menu = "Chose the correct option:\n1. \tRestore Health\n2. \tLose Health\nq. \tGo Back";
    System.out.println("So you need to make a change to your health?\n" + menu);
    char input;
    do {
      if (zeldaPlayer.getDead()) {
        System.out.println(
            "All you can do while dead is wait to be revived. For your sake, I hope your party members are helpful, and I hope you're not the healer.");
        System.out.println(menu);
      }
      if (zeldaPlayer.getDying() && !zeldaPlayer.getDead()) {
        System.out.println(
            "All you can do while unconscious is take damage and wait for your allies to heal you. Hope you weren't the healer!");
        System.out.println(menu);
      }
      do {
        String choice;
        do{
          choice = kb.nextLine();
        }while(! Inputs.verifyCharInput(choice));
        input = choice.charAt(0);
        keepShowing = false;
        switch (input) {
          case '1':
            System.out.println("Enter the amount of hit points you restored. And don't try to go over your max!");
            int restore;
            String in;
            do{
              in = kb.nextLine();
            }while(! Inputs.verifyIntInput(in, false));
            restore = Integer.valueOf(in);
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
              System.out.println("You are no longer dead, but you are still unconscious. Heal up some more.");
            }
            if (zeldaPlayer.getHealth() > 0 && (zeldaPlayer.getDying() || zeldaPlayer.getDead())) {
              zeldaPlayer.setDead(false);
              zeldaPlayer.setDying(false);
              System.out.println("You are no longer unconscious. Congratulations.");
            }
            break;
          case '2':
            int dmg;
            System.out.println("So you took some damage, huh? Well, tell me how much you took.");
            do{
              in = kb.nextLine();
            }while(! Inputs.verifyIntInput(in, false));
            dmg = Integer.valueOf(in);
            if (zeldaPlayer.getHealth() - dmg <= 0) {
              if (zeldaPlayer.getHealth() - dmg <= -10) {
                System.out.println(
                    "You have died. You cannot do anything else until you are revived by your party members. Sucks to be you.");
                zeldaPlayer.changeHP(-(zeldaPlayer.getHealth() + 10));
                zeldaPlayer.setDead(true);
              } else {
                System.out.println("Ouch, looks like you're unconscious. You must wait for a party member to heal you.");
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

  private static void magicMenu(@NotNull ZeldaPlayer zeldaPlayer) {

  }

  private static void expMenu(@NotNull ZeldaPlayer zeldaPlayer) {

  }

  public static void track(@NotNull ZeldaPlayer zeldaPlayer) {
    boolean keepGoing = true;
    String menu = "\n\n1. \tRoll D4\n2. \tRoll D6\n3. \tRoll D8\n4. \tRoll D10\n5. \tRoll D12\n6. \tRoll D20\n7. \tRoll D100 (Percentage Die)\n8. \tModify Health\n9. \tModify Magic\ne. \tAdd Experience\ns. \tShow Stats\nq. \tQuit\n";
    System.out.println("Please chose one of the following options. If you would like to quit press \"q\".\n" + menu);
    char choice;
    do {
      String input;
      do{
        input = kb.nextLine();
      }while(! Inputs.verifyCharInput(input));
      choice = input.charAt(0);
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
}