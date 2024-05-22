const input = require('fs').readFileSync(0).toString().split("\n");
let n = +input[0];
let arr = input[1].split(" ").map(Number);
let index = 0;
let cnt = 0;
let ans = 0;
let now = arr[0];
while(index < n - 1) {
    if(arr[index + 1] < now) {
        cnt++;
        index++;
    } else {
        index++;
        ans = Math.max(ans, cnt);
        cnt = 0;
        now = arr[index];
    }
}
ans = Math.max(ans, cnt);
console.log(ans);
