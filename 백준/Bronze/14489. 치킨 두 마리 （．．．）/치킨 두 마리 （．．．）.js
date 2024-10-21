let [a, b] = require('fs').readFileSync(0).toString().trim().split("\n");
let n = a.split(" ").map(Number).reduce((a, b) => a + b);
b = +b << 1;
console.log(n >= b ? n - b : n);