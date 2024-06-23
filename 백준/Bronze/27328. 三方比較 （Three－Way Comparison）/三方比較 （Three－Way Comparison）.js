let [a, b] = require('fs').readFileSync(0).toString().trim().split("\n").map(Number);
console.log(a < b ? -1 : a == b ? 0 : 1);