let [[n, m], arr1, arr2] = require('fs').readFileSync(0).toString().trim().split("\n").map(e => e.split(" ").map(Number));
const set = new Set(arr1);
let cnt = 0;
arr2.forEach(e => {
    if(set.has(e))
        cnt++;
});
console.log(n + m - (cnt << 1));