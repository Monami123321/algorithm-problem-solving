const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

let arr = new Array(251).fill(0)
arr[0] = 1n
arr[1] = 1n
for(let i = 2 ; i<=250; i++) {
    arr[i] = arr[i-2] * 3n + arr[i-1] - arr[i-2]
}
let ans = ""
input.forEach(e => {
    ans += arr[e] + "\n"
})
console.log(ans)





