const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
let [n, c] = input[0].split(" ").map(Number);
let arr = input[1].split(" ").map(Number);

let hm = new Map();

class Node {
  constructor(index) {
    this.index = index;
  }
}

arr.forEach((e, index) => {
  if (!hm.has(e)) {
    let node = new Node(index);
    node.data = e;
    node.cnt = 1;
    hm.set(e, node);
  } else {
    let node = hm.get(e);
    node.cnt++;
  }
});
arr.sort((a, b) => {
  let nodeA = hm.get(a);
  let nodeB = hm.get(b);
  if (nodeA.cnt !== nodeB.cnt) {
    return nodeB.cnt - nodeA.cnt;
  }
  return nodeA.index - nodeB.index;
});
let ans = ""
arr.forEach(e => ans += e + " ")
console.log(ans)
