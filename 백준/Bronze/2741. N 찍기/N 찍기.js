let n = +require('fs').readFileSync(0);
let ans = ""
let i = 1;
while(i <= n) {
    ans += `${i++}\n`
}
console.log(ans);