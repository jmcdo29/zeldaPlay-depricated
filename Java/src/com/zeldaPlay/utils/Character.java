package com.zeldaPlay.utils;

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

  public Character(String name, String desc, String race, int str, int dex, int con, int intel, int wis, int cha){
    this.name = name;
    this.description = desc;
    this.race = race;
    this.setStr(str);
    this.setDex(dex);
    this.setCon(con);
    this.setIntel(intel);
    this.setWis(wis);
    this.setCha(cha);
    this.calcHp();
    this.calcMp();
    this.experience = 0;
  }

  private void calcHp(){
    this.healthPoints = 48 + this.conBon;
  }

  private void calcMp(){
    this.magicPoints = 20 + this.wisBon;
  }

  private Integer calcBonus(int stat){
    return stat % 2 == 0 ? (stat - 10) /2 : (stat - 11) / 2;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDesc(String desc) {
    this.description = desc;
  }

  public void setStr(int str) {
    this.strength = str;
    this.strBon = calcBonus(str);
  }

  public void setDex(int dex) {
    this.dexterity = dex;
    this.dexBon = calcBonus(dex);
  }

  public void setCon(int con) {
    this.constitution = con;
    this.conBon = calcBonus(con);
  }

  public void setIntel(int intel) {
    this.intelligence = intel;
    this.intBon = calcBonus(intel);
  }

  public void setWis(int wis) {
    this.wisdom = wis;
    this.wisBon = calcBonus(wis);
  }

  public void setCha(int cha) {
    this.charisma = cha;
    this.chaBon = calcBonus(cha);
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

  public ArrayList<String> readNotes(){
    return this.notes;
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