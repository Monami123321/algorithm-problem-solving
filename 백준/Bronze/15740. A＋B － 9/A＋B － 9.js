let [a, b] = require('fs').readFileSync(0).toString().split(" ").map(BigInt);
console.log((a+b).toString())