let n = +require('fs').readFileSync(0).toString().split("\n")[0];
let ans = "";
for(let i = 1; i <= n; ++i) {
    ans += `Material Management ${i}
Classification ---- End!\n`
}
console.log(ans);