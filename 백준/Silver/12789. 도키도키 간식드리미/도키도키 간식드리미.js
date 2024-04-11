const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
let n = +input[0];
let arr = input[1].split(" ").map(Number);
let stack = [];

let index = 0;
let now = 1;
let stackIndex = -1;
while (index < n) {
  if (arr[index] === now) {
    ++index;
    ++now;
  } else {
    if (stackIndex !== -1 && stack[stackIndex] === now) {
      --stackIndex;
      ++now;
    } else {
      if (stack[stackIndex] < arr[index]) {
        console.log("Sad");
        return;
      }
      stack[++stackIndex] = arr[index++];
    }
  }
}
console.log("Nice");
