let [n, arr] = require('fs').readFileSync(0).toString().trim().split("\n");
let [a, b] = arr.split(" ").map(Number);
console.log(Math.min(n, (a >> 1) + b));

