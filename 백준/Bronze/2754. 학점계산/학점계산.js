const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim();
let ans = 0;
if (input.charAt(0) === "A") {
  ans += 4;
} else if (input.charAt(0) === "B") {
  ans += 3;
} else if (input.charAt(0) === "C") {
  ans += 2;
} else if (input.charAt(0) === "D") {
  ans += 1;
}

if (input.charAt(1) === "+") {
  ans += 0.3;
} else if (input.charAt(1) === "-") {
  ans -= 0.3;
}

console.log(ans.toFixed(1));
