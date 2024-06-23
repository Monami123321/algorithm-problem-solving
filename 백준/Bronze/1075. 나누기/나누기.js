let [n, m] = require('fs').readFileSync(0).toString().trim().split("\n").map(Number);
 n = Math.floor(n / 100) * 100;
while(n % m !== 0)  {
    ++n;
}
let ans = n % 100;
console.log(ans < 10 ? "0" + ans : ans);
