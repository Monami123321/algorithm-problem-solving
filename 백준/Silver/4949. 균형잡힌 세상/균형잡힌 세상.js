const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
let ans = "";
let stack = [];
input.forEach((e) => {
  if (e === ".") {
    return;
  }
  const len = e.length;
  for (let i = 0; i < len; i++) {
    let now = e.charAt(i);
    if (now === "(" || now === "[") {
      stack.push(now);
    } else if (now === ")") {
      if (stack[stack.length - 1] === "(") {
        stack.pop();
      } else {
        ans += "no\n";
        stack = [];
        return;
      }
    } else if (now === "]") {
      if (stack[stack.length - 1] === "[") {
        stack.pop();
      } else {
        ans += "no\n";
        stack = [];
        return;
      }
    }
  }
  if (stack.length === 0) {
    ans += "yes\n";
  } else {
    ans += "no\n";
  }
  stack = [];
});
console.log(ans);
