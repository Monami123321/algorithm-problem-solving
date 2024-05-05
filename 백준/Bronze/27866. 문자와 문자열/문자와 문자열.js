const [word,n] = require('fs').readFileSync(0).toString().trim().split("\n");
console.log(word[+n -1]);