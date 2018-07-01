var express = require('express');
var app = express();
var compression = require('compression')

app.use(compression())
app.use(express.static('public'));

app.listen(3000);
