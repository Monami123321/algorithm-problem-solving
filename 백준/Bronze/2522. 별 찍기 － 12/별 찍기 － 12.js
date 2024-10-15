let n = +require('fs').readFileSync(0);
let ans = "";
for(let i = 1; i <= n; ++i) {
    ans += `${" ".repeat(n - i)}${"*".repeat(i)}\n`
}
for(let i = n - 1; i >= 1; --i) {
    ans += `${" ".repeat(n - i)}${"*".repeat(i)}\n`
}
console.log(ans);