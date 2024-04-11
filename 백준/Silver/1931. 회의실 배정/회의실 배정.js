const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
let n = +input[0];
let arr = new Array(n)
  .fill(0)
  .map((e, index) => input[index + 1].split(" ").map(Number));

arr.sort((a, b) => {
  if (a[0] == b[0]) {
    return a[1] - b[1];
  }
  return a[0] - b[0];
});
let ans = 1;
let end = arr[0][1];

for (let i = 1; i < n; i++) {
    let now = arr[i];
    if(now[0] >= end) {
        ans++;
        end = now[1];
    } else if(now[1] < end) {
        end = now[1]
    }
}
console.log(ans)
