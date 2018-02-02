package com.zeldaPlay;

import java.util.Scanner;


public class Main{

  public static void main(String[] args){
    Scanner kb = new Scanner(System.in);
    System.out.println("Hello!");
    System.out.println("Please enter your name.");
    String name = kb.nextLine();
    System.out.println("Great! Nice to meet you "+name+"! How strong are you?");
    int str = kb.nextInt();
    System.out.println(str>15?"Wow! That's pretty strong!":"Oh, I'm guessing you rely on magic or something.");
    System.out.println("How agile are you?");
    int dex = kb.nextInt();
    System.out.println(dex>15?"Very nice! I'm guessing you can't take a hit though.":"Oh, well, I hope you can take a few hits on the field.");
    System.out.println("Speaking of which, what is your constitution?");
    int con = kb.nextInt();
    System.out.println(con>15?"You can definitely take a hit!":"Well, try not to get hit too much");
    System.out.println("How smart would you say you are?");
    int intel = kb.nextInt();
    System.out.println(intel>15?"Oh don't we have a wiz kid over here!":"Eh, intelligence is overrated anyways.");
    System.out.println("What really matters is how sensible you are.");
    int wis = kb.nextInt();
    System.out.println(wis>15?"You definitely aren't stupid in the streets.":"Maybe you shouldn't do the talking in a party. Don't want to offend anyone.");
    System.out.println("Now, can you lie?");
    int cha = kb.nextInt();
    System.out.println(cha>15?"Remind me not to let you near my money. I'll never get it back":"Oh, good to know *snickers* sucker.");
    System.out.println("On a scale of 0 to x, what would x be to represent your health and magic? Just give me two numbers I'll figure it out.");
    int hp = kb.nextInt();
    int mp = kb.nextInt();
    Character character = new Character(name, "", "Hylian", str, dex, con, intel, wis, cha, hp, mp);
    System.out.println("For now, I'm assuming you're a Hylian, but that can change later");
    System.out.println("Your name is:\t\t\t"+character.getName());
    System.out.println("Your strength is:\t\t"+character.getStr());
    System.out.println("Your dexterity is:\t\t"+character.getDex());
    System.out.println("Your constitution is:\t\t"+character.getCon());
    System.out.println("Your intelligence is:\t\t"+character.getInt());
    System.out.println("Your wisdom is:\t\t\t"+character.getWis());
    System.out.println("Your charisam is:\t\t"+character.getCha());
    System.out.println("Your health points are:\t\t"+character.getHealth());
    System.out.println("Your magic points are:\t\t"+character.getMagic());
    kb.close();
  }

}