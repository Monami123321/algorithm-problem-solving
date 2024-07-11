let n = require('fs').readFileSync(0).toString().trim().split("\n")[1].split(" ")
    .reduce((total, now) => total + +now, 0);
console.log(n > 0 ? "Right" : n == 0 ? "Stay" : "Left");