const input = require('fs').readFileSync(0).toString().split("\n");
let [n, x, k] = input.shift().split(" ").map(Number);
input.forEach(e => {
    let [a, b] = e.split(" ").map(Number);
    if(a !== x && b !== x) {
        return;
    }
    if(a === x) {
        x = b;
    } else {
        x = a;
    }
});
console.log(x);