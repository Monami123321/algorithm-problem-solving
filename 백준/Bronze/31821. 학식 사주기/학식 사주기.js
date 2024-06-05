const input = require('fs').readFileSync(0).toString().trim().split("\n").map(Number);
let arr = input.slice(1, input[0] + 1);
let pick = input.slice(input[0] + 2);
console.log(pick.reduce((total,now) => total + arr[now - 1], 0));