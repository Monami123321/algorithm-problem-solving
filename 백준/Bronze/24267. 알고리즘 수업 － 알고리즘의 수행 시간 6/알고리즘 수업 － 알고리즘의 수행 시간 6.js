let n = require('fs').readFileSync(0);
n = BigInt(n);
console.log((n * (n - 1n) * (n - 2n) / 3n >> 1n).toString());
console.log(3);