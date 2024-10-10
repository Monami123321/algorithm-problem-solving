let input = require('fs').readFileSync(0).toString().trim().split("\n");
let n = +input[0];
let arr = input.slice(1).map(e=>e.split(" ").map(Number));
const dp = new Array(3).fill(0).map(e=>new Array(n + 1).fill(0));

for(let i = 1; i <= n; ++i) {
    dp[0][i] = arr[i - 1][0] + Math.min(dp[1][i - 1], dp[2][i - 1]);
    dp[1][i] = arr[i - 1][1] + Math.min(dp[0][i - 1], dp[2][i - 1]);
    dp[2][i] = arr[i - 1][2] + Math.min(dp[0][i - 1], dp[1][i - 1]);
}
console.log(Math.min(Math.min(dp[0][n], dp[1][n]),dp[2][n]));