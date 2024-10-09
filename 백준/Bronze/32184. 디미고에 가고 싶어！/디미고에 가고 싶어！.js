let [a, b] = require('fs').readFileSync(0).toString().split(" ").map(Number);
let ans = 0;
if((a & 1) === 0) {
    ++ans;
    ++a;
}
if((b & 1) !== 0) {
    ++ans;
    --b;
}
console.log(ans + 1 + ((b - a) >> 1));
