let [a, b, c] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
console.log(b * c / (a << 1));