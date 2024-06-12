let [h, m] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
console.log(h * 60 + m - 540);