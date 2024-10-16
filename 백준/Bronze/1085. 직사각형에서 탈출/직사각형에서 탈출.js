let [a,b,c,d] = require('fs').readFileSync(0).toString().split(" ").map(Number);
console.log(Math.min(c - a, a, b, d - b));