let [a, b, c] = require('fs').readFileSync(0).toString().split(" ").map(Number);
console.log(b * (c + 1));