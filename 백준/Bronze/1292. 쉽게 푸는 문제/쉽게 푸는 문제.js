const [start, end] = require('fs').readFileSync('/dev/stdin').toString().trim().split(" ").map(Number);
let now = 0;
let cnt = 0;
let arr = new Array(end+1).fill(0).map(e=> {
    if(now === cnt) {
        cnt = 1;
        return now++;
    } else {
        cnt++;
        return now;
    }
});
let ans = 0;
for(let i = start; i <= end; ++i) {
    ans += arr[i];
}
console.log(ans);
