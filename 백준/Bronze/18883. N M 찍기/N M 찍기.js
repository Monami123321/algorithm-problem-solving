const [n, m] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
let num = 1;
let ans = "";
for(let i = 0; i < n; ++i) {
    for(let j = 0; j < m -1; ++j) {
        ans += num++ + " ";
    }
    ans += num++ +"\n";
}
console.log(ans);