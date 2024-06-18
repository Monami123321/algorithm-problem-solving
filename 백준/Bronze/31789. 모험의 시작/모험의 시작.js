const input = require('fs').readFileSync(0).toString().trim().split("\n");
let [n, m] = input[1].split(" ").map(Number);
console.log(input.slice(2).map(e => e.split(" ").map(Number)).some(e=> e[0] <= n && e[1] > m) ? "YES" : "NO");
