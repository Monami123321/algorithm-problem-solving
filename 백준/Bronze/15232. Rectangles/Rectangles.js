const [r, c] = require('fs').readFileSync('/dev/stdin').toString().trim().split("\n").map(Number);
let ans =""
for(let i = 0; i < r; ++i) {
    for(let j = 0; j < c; ++j) {
        ans += "*";
    }
    ans += "\n";
}
console.log(ans);