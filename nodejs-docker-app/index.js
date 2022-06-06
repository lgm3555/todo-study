const express = require('express');

//Constant
const PORT = 8080;

//APP
const app = express();
app.get('/', (req, res) => {
    res.send('반가워요~~~~');
});

app.listen(PORT);
console.log("Server is running")