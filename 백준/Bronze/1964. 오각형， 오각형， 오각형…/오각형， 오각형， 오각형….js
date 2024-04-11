const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let n = +fs.readFileSync(filePath).toString().trim() - 1;
const MOD = 45678;

let ans = 5;
let diff = 7;
for (let i = 0; i < n; ++i) {
  ans += diff;
  ans %= MOD;
  diff += 3;
}
console.log(ans);
