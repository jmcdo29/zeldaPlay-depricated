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
  private int strBon;
  private int dexBon;
  private int conBon;
  private int intBon;
  private int wisBon;
  private int chaBon;
  private ArrayList<String> notes;
  
  public Character(){};

  public Character(String name, String desc, String race, int str, int dex, int con, int intel, int wis, int cha, int hp, int mp){
    this.name = name;
    this.description = desc;
    this.race = race;
    this.setStr(str);
    this.setDex(dex);
    this.setCon(con);
    this.setIntel(intel);
    this.setWis(wis);
    this.setCha(cha);
    this.setHP(hp);
    this.setMP(mp);
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
    this.strBon = str % 2 == 0 ? (str - 10) / 2 : (str - 11) / 2;
  }

  public void setDex(int dex) {
    this.dexterity = dex;
    this.dexBon = dex % 2 == 0 ? (dex - 10) / 2 : (dex - 11) / 2;
  }

  public void setCon(int con) {
    this.constitution = con;
    this.conBon = con % 2 == 0 ? (con - 10) / 2 : (con - 11) / 2;
  }

  public void setIntel(int intel) {
    this.intelligence = intel;
    this.intBon = intel % 2 == 0 ? (intel - 10) / 2 : (intel - 11) / 2;
  }

  public void setWis(int wis) {
    this.wisdom = wis;
    this.wisBon = wis % 2 == 0 ? (wis - 10) / 2 : (wis - 11) / 2;
  }

  public void setCha(int cha) {
    this.charisma = cha;
    this.chaBon = cha % 2 == 0 ? (cha - 10) / 2 : (cha - 11) / 2;
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
  
  public Integer getStrBon(){
    return this.strBon;
  }

  public Integer getDexBon(){
    return this.dexBon;
  }

  public Integer getConBon(){
    return this.conBon;
  }

  public Integer getIntBon(){
    return this.intBon;
  }

  public Integer getWisBon(){
    return this.wisBon;
  }

  public Integer getChaBon(){
    return this.chaBon;
  }
}