const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
let n = +input[0];
if (n == 1) {
  console.log(input[1]);
  return;
}
let arr = new Array(n).fill(0).map((e, index) => {
  return +input[index + 1];
});
arr.unshift(0);
let dp = new Array(n + 1);
dp[0] = 0;
dp[1] = arr[1];
dp[2] = arr[1] + arr[2];
for (let i = 3; i <= n; i++) {
  dp[i] = Math.max(
    Math.max(Math.max(dp[i - 2] + arr[i]), dp[i - 3] + arr[i] + arr[i - 1]),
    dp[i - 1]
  );
}
console.log(dp[n]);
