const express = require('express');
const logger = require('./utils/logger').logExceptOnTest;
const bodyParser = require('body-parser');
const validate = require('express-validator');
const router = require('./routes/routes');
const app = express();
const PORT = process.env.PORT || 3050;

app.use((req,res,next)=>{
  const str = "Request made to "+req.path+" at "+new Date(Date.now()).toLocaleString();
  logger(str);
  next();
});

app.set('view engine', 'pug');
app.use(express.static('./public'));
app.use(validate());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:false}));

app.use('/',router);

app.listen(PORT, ()=>{
  let str = 'Server is listening on port '+PORT;
  logger(str);
});

module.exports = app;