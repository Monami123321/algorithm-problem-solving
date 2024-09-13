let [n, m] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
let ans;
if(n === 1) {
    ans = 1;
} else if (n === 2) {
    ans = Math.min(4, (m - 1 >> 1) + 1);
} else if (m < 5) {
    ans = m;
} else if (m < 7) {
    ans = 4;
} else {
    ans = m - 2;
}
console.log(ans);

