const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
let [n, m] = input[0].split(" ").map(Number);
let map = new Array(n).fill(0).map((e, index) => {
  let now = input[index + 1].split(" ").map(Number);
  now.unshift(0);
  now.push(0);
  return now;
});

let dr = [-1, 1, 0, 0];
let dc = [0, 0, -1, 1];
map.push(new Array(m + 2).fill(0));
map.unshift(new Array(m + 2).fill(0));
let ans = 0;
for (let i = 1; i < n + 1; ++i) {
  for (let j = 1; j < m + 1; ++j) {
    if (map[i][j] === 0) {
      ans -= 2;
      continue;
    }
    let sum = 0;
    for (let k = 0; k < 4; ++k) {
      let nr = i + dr[k];
      let nc = j + dc[k];
      sum += Math.max(0, map[i][j] - map[nr][nc]);
    }
    ans += sum;
  }
}
ans += m * n * 2;
console.log(ans);
