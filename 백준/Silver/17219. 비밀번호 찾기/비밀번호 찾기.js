let [nm, ...input] = require('fs').readFileSync(0).toString().trim().split("\n");
let [n, m] = nm.split(" ").map(Number);
const map = new Map()
for(let i = 0; i < n; ++i) {
    const now = input[i].trim().split(" ");
    map.set(now[0], now[1]);
}
console.log(input.slice(n).map(e => map.get(e)).join("\n"));