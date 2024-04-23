const [n,m,k] = require('fs').readFileSync('/dev/stdin').toString().trim().split("\n").map(Number)
console.log(Math.floor(m/n)*k)