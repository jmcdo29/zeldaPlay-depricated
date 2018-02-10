package com.zeldaPlay.utils;

import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class InputsTest{

  @Test
  public void verifyIntInputTest(){
    assertTrue(Inputs.verifyIntInput("12", false));
    assertTrue(Inputs.verifyIntInput("123", false));
    assertFalse(Inputs.verifyIntInput("123", true));
    assertFalse(Inputs.verifyIntInput("-123", false));
    assertFalse(Inputs.verifyIntInput("631", false));
    assertFalse(Inputs.verifyIntInput("q", false));
    assertFalse(Inputs.verifyIntInput("0", false));
  }

  @Test
  public void verifyStringInputTest(){
    assertFalse(Inputs.verifyStringInput("                   "));
    assertFalse(Inputs.verifyStringInput(""));
    assertTrue(Inputs.verifyStringInput("Bryte the Destroyer"));
  }

  @Test
  public void verifyCharInputTest(){
    assertTrue(Inputs.verifyCharInput("s"));
    assertFalse(Inputs.verifyCharInput("sasdf"));
  }

}