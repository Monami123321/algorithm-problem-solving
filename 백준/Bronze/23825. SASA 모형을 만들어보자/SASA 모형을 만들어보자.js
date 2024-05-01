let [a, b] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
console.log(Math.min(a>>1,b>>1));