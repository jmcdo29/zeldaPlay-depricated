const express = require('express');
const logger = require('./utils/logger').logExceptOnTest;
const bodyParser = require('body-parser');
const app = express();
const router = express.Router();
const PORT = process.env.PORT || 3050;

app.use((req,res,next)=>{
  const str = "Request made to "+req.path+" at "+new Date(Date.now()).toLocaleString();
  logger(str);
  next();
});

app.set('view engine', 'pug');
app.use(express.static('./public'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:false}));

app.get('/', (req,res,next)=>{
  res.render('Home');
});

app.listen(PORT, ()=>{
  let str = 'Server is listening on port '+PORT;
  logger(str);
});