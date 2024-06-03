let [a, b, c] =require('fs').readFileSync(0).toString().trim().split("\n").map(BigInt);
console.log(((b - c) / a).toString());