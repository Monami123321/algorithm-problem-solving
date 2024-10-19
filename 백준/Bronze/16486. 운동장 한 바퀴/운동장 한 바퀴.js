let [a, b] = require('fs').readFileSync(0).toString().trim().split("\n").map(Number);
console.log((a << 1) + (b << 1) * 3.141592);