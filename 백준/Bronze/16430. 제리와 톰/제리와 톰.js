let [a, b] = require('fs').readFileSync(0).toString().split(" ").map(Number);
console.log(`${b-a} ${b}`);