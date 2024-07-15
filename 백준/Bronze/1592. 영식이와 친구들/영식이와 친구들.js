let [n, m, l] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
const arr = new Array(n).fill(0);
arr[0] = 1;
let index = 0;
let cnt = 0;
while(arr[index] < m) {
    if((arr[index] & 1) == 0) {
        index = (index + n - l) % n;
    } else {
        index = (index + l) % n;
    }
    arr[index]++;
    cnt++;
}
console.log(cnt);
