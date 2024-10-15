let n = +require('fs').readFileSync(0);
let ans = "";
for(let i = 1; i <= n; ++i) {
    ans += "*".repeat(i) + "\n";
}
while(--n > 0) {
    ans += "*".repeat(n) + "\n";
}
console.log(ans);