let [n, k] = require('fs').readFileSync(0).toString().split(" ").map(Number);
const arr = [];
k %= 10;
const k2 = (k << 1) % 10;
for(let i = 1; i <= n; ++i) {
    let now = i % 10;
    if(now !== k && now !== k2) {
        arr.push(i);
    }
}
console.log(arr.length);
if(arr.length !==0) {
    console.log(arr.join(" "));
}
