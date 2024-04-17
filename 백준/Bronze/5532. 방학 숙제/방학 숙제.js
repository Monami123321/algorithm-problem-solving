let [l,a,b,c,d]  = require('fs').readFileSync('/dev/stdin').toString().trim().split("\n").map(Number)
console.log(l-Math.max(Math.ceil(a / c) ,Math.ceil(b/d)))
