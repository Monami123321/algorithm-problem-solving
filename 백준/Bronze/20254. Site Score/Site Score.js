let [a, b, c, d] = require('fs').readFileSync(0).toString().split(" ").map(Number);
console.log(a * 56 + b * 24 + c * 14 + 6 * d);