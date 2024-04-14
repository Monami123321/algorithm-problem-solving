let input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
let n = +input[0];
let arr = new Array(n)
  .fill(0)
  .map((e, index) => input[index + 1].split(" ").map(Number));

let visited = new Array(101).fill(0)
let score = new Array(n).fill(0)
for(let j  = 0; j<3; j++) {
    for(let i = 0; i<n; i++) {
        visited[arr[i][j]]++
    }
    for(let i = 0; i<n; i++) {
        if(visited[arr[i][j]] === 1) {
            score[i] += arr[i][j]
        }
    }
    for(let i = 0; i<101; i++) {
        visited[i] = 0
    }
}
let ans = ""
for(let i = 0; i<n ; i++) {
    ans += score[i] + "\n"
}
console.log(ans)
