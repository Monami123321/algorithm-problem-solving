let input = require('fs').readFileSync(0).toString().trim().split("\n").map(e => e.split(" ").map(Number));
let [n, m, r] = input.shift();

const adjList = new Array(n + 1).fill(0).map(e=>new Array());
input.forEach(e => {
    adjList[e[0]].push(e[1]);
    adjList[e[1]].push(e[0]);
});
adjList.map(e => e.sort((a,b) => +a - +b ));
const visited = new Array(n + 1).fill(false);
let ans = new Array(n).fill(0);
let cnt = 1;
dfs(r);
console.log(ans.join("\n"));

function dfs(n) {
    visited[n] = true;
    ans[n - 1] = cnt++;
    adjList[n].forEach(e => {
        if(!visited[e]) dfs(e)
    });
}


