const arr = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(e => e.split(" ").map(Number))
let ans = ""
let dp = new Array(5001).fill(false)
for (let i = 1; i < 5001; i++) {
    dp[i] = isPossible(i)
}
arr.forEach(e => {
    let cnt = 0;
    for (let i = e[0]; i <= e[1]; i++) {
        if(dp[i]) {
            cnt++
        }
    }
    ans += cnt + "\n"
});
console.log(ans)

function isPossible(n) {
    let str = n.toString();
    let cnt = new Array(10).fill(0)
    for (let i = 0; i < str.length ; i++) {
        cnt[+(str.charAt(i))]++
    }
    return !cnt.find(e => e>1)
}


