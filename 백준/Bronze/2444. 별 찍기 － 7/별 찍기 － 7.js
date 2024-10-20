let n = +require('fs').readFileSync(0);
let ans = "";
for(let i = 0; i < n; ++i) {
    ans += " ".repeat(n - 1 - i) + "*".repeat(i << 1 | 1) + "\n";
}
for(let i = n - 2; i >= 0; --i) {
    ans += " ".repeat(n - 1 - i) + "*".repeat(i << 1 | 1) + "\n";
}
console.log(ans);
