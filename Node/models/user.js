const mong = require('mongoose');
const bcrypt = require('bcryptjs');
const Charcater = require('./character');

const userSchema = mong.Schema({
  email:{
    type:String,
    require: true,
    unique: true
  },
  password:{
    type:String,
    require: true
  },
  chracters:[{
    type: Charcater
  }]
});

