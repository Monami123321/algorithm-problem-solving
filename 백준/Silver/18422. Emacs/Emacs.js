const input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt")
  .toString()
  .split("\n")
  .map((e) => e.trim());
const [n, m] = input.shift().split(" ").map(Number);
const map = input.map((e) => [...e]);
const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];
let ans = 0;
for (let i = 0; i < n; ++i) {
  for (let j = 0; j < m; ++j) {
    if (map[i][j] === ".") {
      continue;
    }
    bfs(i, j);
    ans++;
  }
}
console.log(ans);

function bfs(startR, startC) {
  const q = [[startR, startC]];
  while (q.length !== 0) {
    const [r, c] = q.shift();
    for (let i = 0; i < 4; i++) {
      let nr = r + dr[i];
      let nc = c + dc[i];
      if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || map[nr][nc] === ".") {
        continue;
      }
      q.push([nr, nc]);
      map[nr][nc] = ".";
    }
  }
}
