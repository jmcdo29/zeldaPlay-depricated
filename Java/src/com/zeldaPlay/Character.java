package com.zeldaPlay;

import java.util.*;

public class Character {
  private String name;
  private String description;
  private String race;
  private int strength;
  private int dexterity;
  private int constitution;
  private int intelligence;
  private int wisdom;
  private int charisma;
  private int healthPoints;
  private int magicPoints;
  private int experience;
  private ArrayList<String> notes;
  
  public Character(){};

  public Character(String name, String desc, String race, int str, int dex, int con, int intel, int wis, int cha, int hp, int mp){
    this.name = name;
    this.description = desc;
    this.race = race;
    this.strength = str;
    this.dexterity = dex;
    this.constitution = con;
    this.intelligence = intel;
    this.wisdom = wis;
    this.charisma = cha;
    this.healthPoints = hp;
    this.magicPoints = mp;
    this.experience = 0;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDesc(String desc) {
    this.description = desc;
  }

  public void setStr(int str) {
    this.strength = str;
  }

  public void setDex(int dex) {
    this.dexterity = dex;
  }

  public void setCon(int con) {
    this.constitution = con;
  }

  public void setIntel(int intel) {
    this.intelligence = intel;
  }

  public void setWis(int wis) {
    this.wisdom = wis;
  }

  public void setCha(int cha) {
    this.charisma = cha;
  }

  public void setHP(int hp) {
    this.healthPoints = hp;
  }

  public void setMP(int mp) {
    this.magicPoints = mp;
  }

  public String getName() {
    return this.name;
  }

  public String getDesc() {
    return this.description;
  }

  public String getRace() {
    return this.race;
  }

  public Integer getStr() {
    return this.strength;
  }

  public Integer getDex() {
    return this.dexterity;
  }

  public Integer getCon() {
    return this.constitution;
  }

  public Integer getInt() {
    return this.intelligence;
  }

  public Integer getWis() {
    return this.wisdom;
  }

  public Integer getCha(){
    return this.charisma;
  }

  public Integer getHealth() {
    return this.healthPoints;
  }

  public Integer getMagic() {
    return this.magicPoints;
  }

  public Integer getExp() {
    return this.experience;
  }

  public void addExp(int gains){
    this.experience += gains;
  }

  public void makeNote(String note){
    this.notes.add(note);
  }
}