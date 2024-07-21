let [s, e] = require('fs').readFileSync(0).toString().trim().split("\n").map(Number);
if(s > 3) {
    e += 24 - s;
    s = 0;
}
console.log(e - s);