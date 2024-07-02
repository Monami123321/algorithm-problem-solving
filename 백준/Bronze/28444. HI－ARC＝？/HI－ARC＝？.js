let [a, b, c, d, e] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
console.log(a * b - c *d * e);