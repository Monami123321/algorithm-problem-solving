let n = +require('fs').readFileSync(0);
let dp = new Array(3).fill(0).map(e => new Array(n + 1).fill(0));
const MOD = 9901;
dp[0][0] = 1;
for(let i = 1; i <= n; ++i) {
    dp[0][i] = (dp[0][i - 1] + dp[1][i - 1] + dp[2][i - 1]) % MOD;
    dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % MOD;
    dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % MOD;
}
console.log((dp[0][n] + dp[1][n] + dp[2][n]) % MOD);
