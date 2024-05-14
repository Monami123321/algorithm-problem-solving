const word = require('fs').readFileSync(0).toString().trim();
const map = new Map();
map.set("I","E");
map.set("E","I");
map.set("S","N");
map.set("N","S");
map.set("T","F");
map.set("F","T");
map.set("J","P");
map.set("P","J");
let ans = "";
word.split("").forEach(e=> {
    ans += map.get(e);
});
console.log(ans);
