let arr = require('fs').readFileSync(0).toString().trim().split("\n").map(Number);
let n = arr.shift();
arr = arr.sort((a,b) => +a - +b);

let cut = Math.round(arr.length * 0.15);

console.log(n === 0 ? 0 : Math.round(arr.slice(cut, arr.length - cut).reduce((total, now) => total + now) / (arr.length - (cut << 1))));
