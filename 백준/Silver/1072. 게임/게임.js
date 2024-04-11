let [x, y] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);
if (x === y) {
  console.log(-1);
  return;
}
let z = Math.floor((100 * y) / x);
if (z === 99) {
  console.log(-1);
  return;
}

let start = 1;
let end = x * 2;

while (end >= start) {
  let mid = Math.floor((start + end) / 2);

  if (Math.floor((100 * (y + mid)) / (x + mid)) !== z) {
    end = mid - 1;
  } else {
    start = mid + 1;
  }
}
console.log(start);
