let [m, word] = require('fs').readFileSync(0).toString().trim().split("\n");
m = +m;
let n = word.length / m;
const arr = new Array(n).fill(0).map(e=>new Array(m).fill(0));
let index = 0;
while(index < word.length) {
    let r = Math.floor(index / m);
    let c = (r & 1) === 0 ? index % m : m - 1 - index % m;
    arr[r][c] = word.charAt(index++);
}
let ans = "";
for(let i = 0; i < m; ++i) {
    for(let j = 0; j < n; ++j) {
        ans += arr[j][i];
    }
}
console.log(ans);