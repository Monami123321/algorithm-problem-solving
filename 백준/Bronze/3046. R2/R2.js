const input = require('fs').readFileSync("/dev/stdin").toString().trim().split(" ").map(Number)
console.log((input[1]<<1) - input[0])