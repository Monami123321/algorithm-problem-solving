let [a, b] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
console.log(`${a === b ? 1 : 0}`);