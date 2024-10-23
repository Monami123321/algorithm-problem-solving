let arr = require('fs').readFileSync(0).toString().trim().split("\n").map(Number);
let ans = "";
let idx = 1;
while(arr[0]-- > 0) {
    ans += arr[idx++] * 23 + "\n";
}
console.log(ans);