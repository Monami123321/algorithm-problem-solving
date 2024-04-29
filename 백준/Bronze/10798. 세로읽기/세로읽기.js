let input = require("fs").readFileSync(0).toString().split("\n");
input = input.map((e) => e.trim());
let len = input.reduce((prev, now) => {
  return Math.max(prev, now.length);
}, 0);
const arr = new Array(input.length).fill(0).map((e) => new Array(len).fill(""));
input.forEach((e, i) => {
  e.split("").forEach((el, j) => {
    arr[i][j] = el;
  });
});
let ans = "";
for (let i = 0; i < len; i++) {
  for (let j = 0; j < input.length; j++) {
    ans += arr[j][i];
  }
}
console.log(ans);
