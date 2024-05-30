let [n, m, k] = require("fs")
  .readFileSync(0)
  .toString()
  .trim()
  .split(" ")
  .map(Number);

let diff = (k - 3) % n;

if (diff < 0) {
  while (diff < 0) {
    diff += n;
  }
}
m--;
let ans = (m + diff) % n;
console.log(++ans);
