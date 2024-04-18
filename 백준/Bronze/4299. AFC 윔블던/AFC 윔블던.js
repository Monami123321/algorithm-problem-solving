let [sum, diff] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);
if (sum < 0 || diff < 0 || sum > 1000 || diff > 1000 || diff > sum) {
  console.log(-1);
  return;
}

let a = (sum + diff) / 2;
let b = (sum - diff) / 2;
if (a % 1 !== 0 || b % 1 !== 0) {
  console.log(-1);
  return;
}
if (a + b === sum && a - b === diff) {
  console.log("%d %d", a, b);
} else {
  console.log(-1);
}
