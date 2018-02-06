package com.zeldaPlay.utils;

import java.util.*;

public class ZeldaPlayer {
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
  private int maxHealthPoints;
  private int magicPoints;
  private int maxMagicPoints;
  private int experience;
  private int strBon;
  private int dexBon;
  private int conBon;
  private int intBon;
  private int wisBon;
  private int chaBon;
  private boolean dying;
  private boolean dead;
  private ArrayList<String> notes;

  public ZeldaPlayer(String name, String desc, String race, int str, int dex, int con, int intel, int wis, int cha){
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
    this.setDead(false);
    this.setDying(false);
    this.experience = 0;
  }

  private void calcHp(){
    this.healthPoints = 48 + this.conBon;
    this.maxHealthPoints = this.healthPoints;
  }

  private void calcMp(){
    this.magicPoints = 20 + this.wisBon;
    this.maxMagicPoints = this.magicPoints;
  }

  private int calcBonus(int stat){
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

  public int getStr() {
    return this.strength;
  }

  public int getDex() {
    return this.dexterity;
  }

  public int getCon() {
    return this.constitution;
  }

  public int getInt() {
    return this.intelligence;
  }

  public int getWis() {
    return this.wisdom;
  }

  public int getCha(){
    return this.charisma;
  }

  public int getHealth() {
    return this.healthPoints;
  }

  public int getMagic() {
    return this.magicPoints;
  }

  public int getExp() {
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
  
  public int getStrBon(){
    return this.strBon;
  }

  public int getDexBon(){
    return this.dexBon;
  }

  public int getConBon(){
    return this.conBon;
  }

  public int getIntBon(){
    return this.intBon;
  }

  public int getWisBon(){
    return this.wisBon;
  }

  public int getChaBon(){
    return this.chaBon;
  }

  public int getMaxHP(){
    return this.maxHealthPoints;
  }

  public int getMaxMP(){
    return this.maxMagicPoints;
  }

  public void changeHP(int change){
    this.healthPoints += change;
  }

  public void changeMP(int change){
    this.magicPoints += change;
  }

  public void setDying(boolean dying){
    this.dying = dying;
  }

  public boolean getDying(){
    return this.dying;
  }

  public void setDead(boolean dead){
    this.dead = dead;
  }

  public boolean getDead(){
    return this.dead;
  }

  public void printStats(){
    System.out.println("Your name is:\t\t\t\t"+this.name);
    System.out.println("Your current and max hit points are:\t"+this.healthPoints+"\t"+this.maxHealthPoints);
    System.out.println("Your current and max magic points are:\t"+this.magicPoints+"\t"+this.maxMagicPoints);
    System.out.println("Your strength is:\t\t\t"+this.strength+"\t"+this.strBon);
    System.out.println("Your dexterity is:\t\t\t"+this.dexterity+"\t"+this.dexBon);
    System.out.println("Your constitution is:\t\t\t"+this.constitution+"\t"+this.conBon);
    System.out.println("Your intelligence is:\t\t\t"+this.intelligence+"\t"+this.intBon);
    System.out.println("Your wisdom is:\t\t\t\t"+this.wisdom+"\t"+this.wisBon);
    System.out.println("Your charisma is:\t\t\t"+this.charisma+"\t"+this.chaBon);
  }
}