package com.zeldaPlay.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;


public class CustomExceptionTest{

  private final String MESSAGE = "Testing Exception";

  @Test
  public void BadCharacterExceptionTest(){
    try{
      throw new BadCharacterException(MESSAGE);
    }catch(BadCharacterException bce){
      assertTrue(bce.getMessage().matches(MESSAGE));
    }
  }

  @Test
  public void EmptyStringExceptionTest(){
    try{
      throw new EmptyStringException(MESSAGE);
    }catch(EmptyStringException ese){
      assertTrue(ese.getMessage().matches(MESSAGE));
    }
  }

  @Test
  public void HighInputExceptionTest(){
    try{
      throw new HighInputException(MESSAGE);
    }catch(HighInputException hie){
      assertTrue(hie.getMessage().matches(MESSAGE));
    }
  }

  @Test
  public void HighStatExceptionTest(){
    try{
      throw new HighStatException(MESSAGE);
    }catch(HighStatException hse){
      assertTrue(hse.getMessage().matches(MESSAGE));
    }
  }

  @Test
  public void IntZeroExceptionTest(){
    try{
      throw new IntZeroException(MESSAGE);
    }catch(IntZeroException ize){
      assertTrue(ize.getMessage().matches(MESSAGE));
    }
  }

  @Test
  public void NegativeIntExceptionTest(){
    try{
      throw new NegativeIntException(MESSAGE);
    }catch(NegativeIntException nie){
      assertTrue(nie.getMessage().matches(MESSAGE));
    }
  }
}