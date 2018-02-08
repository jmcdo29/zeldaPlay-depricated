package com.zeldaPlay.player;

import org.junit.*;

public class ZeldaPlayerHelperTest{

  @Test
  public void makeCharacterTest(){
    ZeldaPlayer playerTest = new ZeldaPlayer("String","Description","Race",12,12,12,12,12,12);
    playerTest.printStats();
  }
}