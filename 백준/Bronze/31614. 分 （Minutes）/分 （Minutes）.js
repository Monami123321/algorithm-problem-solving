let[h, m] = require('fs').readFileSync(0).toString().trim().split("\n").map(Number);
console.log(60 * h + m);