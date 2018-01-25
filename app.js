const express = require('express');
const logger = require('./utils/logger').LogExcectOnTest;
const app = express();
const router = express.Router();
const PORT = process.env.PORT || 3000;

app.get('/', (req,res,next)=>{
  res.status(200).json({message:"Hello World"});
});

app.listen(PORT, ()=>{
  let str = 'Server is listening on port '+PORT;
  logger(str);
});