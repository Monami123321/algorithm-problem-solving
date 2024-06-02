const arr = require('fs').readFileSync(0).toString().trim().split("\n").map(Number).sort((a,b) => a-b);
console.log(`${arr.reduce((total,now) => total + now) / 5}\n${arr[2]}`);