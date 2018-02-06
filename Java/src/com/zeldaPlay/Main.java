package com.zeldaPlay;

import com.zeldaPlay.utils.*;
import com.zeldaPlay.Player.*;

public class Main {

  public static void main(String[] args) {
    try {
      System.out.println("Hello!");
      System.out.println(
          "I'm so glad you decided to use me to help you track you zeldaPlay character!\nThroughout the course of this program, I will ask you several questions and give you several choices.\nPlease follow instructions so that I do not have to get mad at you.\nLet's begin.");
      ZeldaPlayer zeldaPlayer = ZeldaPlayerHelper.makeZeldaPlayer();
      System.out.println(
          "Now I will show you a menu of options that you have.\nYou will be able to roll any dice that you want of the polyhedral set.\nYou will also be able to modify your health and magic points as well as gain experience.\nAgain, please try to follow instructions carefully as the GUI has not yet been created.");
      Menus.track(zeldaPlayer);
      System.out.println("Thank you for using this program " + zeldaPlayer.getName() + ".\nHave a great day.");
    } catch (Exception e) {
      System.err.println(e.getMessage() + "\n" + e.getCause());
    }
  }

}