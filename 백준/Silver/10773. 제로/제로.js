const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().split("\n");
let k = +input[0];
let arr = [];
for (let i = 1; i <= k; ++i) {
  let now = +input[i];
  if (now === 0) {
    arr.pop();
  } else {
    arr.push(now);
  }
}
console.log(arr.reduce((prev, curr) => prev + curr, 0));
