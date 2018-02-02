const express = require("express");
const router = express.Router();
const Charcater = require("../models/character");

router
  .get("/", (req, res, next) => {
    res.render("home");
  })
  .get("/character", (req, res, next) => {
    res.render("character");
  })
  .post("/character_prof", (req, res, next) => {
    let name = req.body.name;
    let description = req.body.description;
    let race = req.body.race;
    let str = Number.parseInt(req.body.Strength);
    let dex = Number.parseInt(req.body.Dexterity);
    let con = Number.parseInt(req.body.Constitution);
    let int = Number.parseInt(req.body.Intelligence);
    let wis = Number.parseInt(req.body.Wisdom);
    let cha = Number.parseInt(req.body.Charisma);
    let hp = Number.parseInt(req.body.HP);
    let mp = Number.parseInt(req.body.MP);

    //lots of validation
    req.check("name", "Name is required").notEmpty();
    req.check("race", "Race is required").notEmpty();
    req.check("Strength", "Strength must be a number").isNumeric();
    req.check("Strength", "Strength is required").notEmpty();
    req.check("Dexterity", "Dexterity must be a number").isNumeric();
    req.check("Dexterity", "Dexterity is required").notEmpty();
    req.check("Constitution", "Constitution must be a number").isNumeric();
    req.check("Constitution", "Constitution is required").notEmpty();
    req.check("Intelligence", "Intelligence must be a number").isNumeric();
    req.check("Intelligence", "Intelligence is required").notEmpty();
    req.check("Wisdom", "Wisdom must be a number").isNumeric();
    req.check("Wisdom", "Wisdom is required").notEmpty();
    req.check("Charisma", "Charisma must be a number").isNumeric();
    req.check("Charisma", "Charisma is required").notEmpty();
    req.check("HP", "Health Points must be a number").isNumeric();
    req.check("HP", "Health Points are definitely required").notEmpty();
    req.check("MP", "Magic Points must be a number").isNumeric();
    req.check("MP", "Magic Points are required").notEmpty();

    let errors = req.validationErrors();
    if (errors) {
      res.render("character", { errors });
    } else {
      let newChar = new Charcater({
        name: name,
        description: description,
        race: race,
        strength: str,
        dexterity: dex,
        constitution: con,
        wisdom: wis,
        intelligence: int,
        charisma: cha,
        health_points: hp,
        magic_points: mp,
        experience: 0
      });
      res.render("Profile", { character: newChar });
    }
  }); 

module.exports = router;
