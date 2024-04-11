const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let n = +fs.readFileSync(filePath).toString().trim();
let ans = "";
for (let index = n; index >= 1; index--) {
  ans += " ".repeat(n - index);
  ans += "*".repeat(index);
  ans += "\n";
}
console.log(ans);
