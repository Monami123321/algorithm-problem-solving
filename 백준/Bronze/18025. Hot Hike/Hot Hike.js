let [n, arr] = require('fs').readFileSync(0).toString().trim().split("\n");
arr = arr.split(" ").map(Number);
let ans = 1 << 30;
let idx = 0;
for(let i = 1; i < n -1; ++i) {
    let max = Math.max(arr[i - 1], arr[i + 1]);
    if(ans > max) {
        ans = max;
        idx = i;
    }
}
console.log(`${idx} ${ans}`);