const mong = require("mongoose");

/*
 * initial thought of charcater schema:
 * character will have str,dex,con,wis,int,cha,hp,mp,and exp --known as attrubutes (required number)
 * charcter can have several items  (array of json)
 * character can have several weapons (array of json)
 * items will have description and name (both strings)
 * weapons will have attack type, description and name (all strings)
 * character can have adventure notes (array of strings)
 * character will have a name (required string)
 * character will have a race/class (required string)
 * character will have an optional description (string)
 * charcter will eventually belong to a user (user in mongodb)
 * character will have skills (array of json)
 * skill will have name, attribute type, trained, points (string string bool Number)
 */
const characterSchema = mong.Schema({
  name: {
    type: String,
    require: true
  },
  decription: {
    type: String
  },
  race: {
    type: String,
    required: true
  },
  attributes: {
    strength: {
      type: Number,
      require: true
    },
    dexterity: {
      type: Number,
      require: true
    },
    constitution: {
      type: Number,
      require: true
    },
    wisdom: {
      type: Number,
      require: true
    },
    intelligence: {
      type: Number,
      require: true
    },
    charisma: {
      type: Number,
      require: true
    },
    health_points: {
      type: Number,
      require: true
    },
    magic_points: {
      type: Number,
      require: true
    },
    experience: {
      type: Number,
      require: true
    }
  }
  /* inventory: [
    {
      description: String,
      item_name: String
    }
  ],
  weapon: [
    {
      attack: String,
      name: String,
      description: String
    }
  ],
  notes: [
    {
      type: String
    }
  ],
  skills: [{
    name: String,
    attribute_type: String,
    trained: Boolean,
    points: Number
  }] */
});

module.exports = mongoose.Schema('Charcter', characterSchema);