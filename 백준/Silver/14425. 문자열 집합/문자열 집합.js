const input = require('fs').readFileSync(0).toString().split("\n");
let [n,m] = input.shift().split(" ").map(Number);
const set = new Set();
for(let i = 0; i < n; ++i) {
    set.add(input[i].trim());
}
console.log(input.slice(n).map(e=>e.trim()).reduce((total,now) => {
    if(set.has(now)) {
        return total + 1;
    }
    return total;
},0));