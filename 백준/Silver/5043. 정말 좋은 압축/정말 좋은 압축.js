let [k, b] = require('fs').readFileSync(0).toString().split(" ").map(BigInt);
console.log((1n << b + 1n) - 1n >= k ? "yes" : "no" );