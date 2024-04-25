const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
let [n, m, start] = input[0].split(" ").map(Number);
let adjList = new Array(n + 1).fill(0).map((e) => {
  return [];
});
for (let i = 1; i <= m; i++) {
  let [s, e] = input[i].trim().split(" ").map(Number);
  adjList[s].push(e);
  adjList[e].push(s);
}
adjList.forEach((e) => {
  e.sort((a, b) => a - b);
});
let visited = new Array(n + 1).fill(false);
let ans = "";
dfs(visited, start);
ans += "\n";

visited.fill(false);
let q = [];
q.push(start);
ans += start + " ";
visited[start] = true;
while (q.length !== 0) {
  let now = q.shift();
  adjList[now].forEach((e) => {
    if (visited[e]) {
      return;
    }
    visited[e] = true;
    q.push(e);
    ans += e + " ";
  });
}
console.log(ans);

function dfs(visited, now) {
  visited[now] = true;
  ans += now + " ";
  adjList[now].forEach((e) => {
    if (visited[e]) {
      return;
    }
    dfs(visited, e);
  });
}
