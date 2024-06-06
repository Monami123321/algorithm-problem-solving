const input = require('fs').readFileSync(0).toString().trim().split("\n");
let target = input.shift().slice(0,5);
input.shift();
console.log(input.filter(e => e.startsWith(target)).length);