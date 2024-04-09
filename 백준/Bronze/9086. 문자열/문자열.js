const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
let testCases = +input[0];
let res = "";
for (let i = 1; i <= testCases; ++i) {
  let len = input[i].trim().length;
  res += input[i].charAt(0) + input[i].charAt(len - 1) + "\n";
}
console.log(res)
