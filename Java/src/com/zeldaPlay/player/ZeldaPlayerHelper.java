package com.zeldaPlay.player;

import com.zeldaPlay.utils.Inputs;

import java.util.Scanner;

public class ZeldaPlayerHelper{

  private static final Scanner kb = new Scanner(System.in);

  private static int verify(){
    String stat;
    do{
      stat = kb.nextLine();
    }while(! Inputs.verifyIntInput(stat, true));
    return Integer.valueOf(stat);
  }

  public static ZeldaPlayer makeZeldaPlayer() {
    System.out.println("Please enter your name.");
    //String name = Inputs.getStringInput();
    String name;
    do{
      name = kb.nextLine();
    }while(! Inputs.verifyStringInput(name));
    System.out.println("Great! Nice to meet you " + name + "! How strong are you?");
    int str = verify();
    System.out.println(str > 15 ? "Wow! That's pretty strong!" : "Oh, I'm guessing you rely on magic or something.");
    System.out.println("How agile are you?");
    int dex = verify();
    System.out.println(dex > 15 ? "Very nice! I'm guessing you can't take a hit though."
        : "Oh, well, I hope you can take a few hits on the field.");
    System.out.println("Speaking of which, what is your constitution?");
    int con = verify();
    System.out.println(con > 15 ? "You can definitely take a hit!" : "Well, try not to get hit too much");
    System.out.println("How smart would you say you are?");
    int intel = verify();
    System.out.println(intel > 15 ? "Oh don't we have a wiz kid over here!" : "Eh, intelligence is overrated anyways.");
    System.out.println("What really matters is how sensible you are.");
    int wis = verify();
    System.out.println(wis > 15 ? "You definitely aren't stupid in the streets."
        : "Maybe you shouldn't do the talking in a party. Don't want to offend anyone.");
    System.out.println("Now, can you lie?");
    int cha = verify();
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
}