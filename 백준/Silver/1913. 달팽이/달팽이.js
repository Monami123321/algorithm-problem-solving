let [n, target] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);
const arr = new Array(n).fill(0).map((e) => new Array(n).fill(0));

const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];

let r = (n - 1) >> 1;
let c = (n - 1) >> 1;
let dir = 0;
let cnt = 0;
let ref = 1;
let refCnt = 0;

n *= n;
let now = 1;
let pos = "";
while (now <= n) {
  if (now === target) {
    pos += `${r + 1} ${c + 1}`;
  }
  arr[r][c] = now++;
  r += dr[dir];
  c += dc[dir];
  cnt++;
  if (cnt === ref) {
    cnt = 0;
    refCnt++;
    dir = (dir + 1) % 4;
  }
  if (refCnt == 2) {
    ref++;
    refCnt = 0;
  }
}
let ans = "";
arr.forEach((e) => {
  e.forEach((el) => {
    ans += el + " ";
  });
  ans += "\n";
});
ans += pos;
console.log(ans);
