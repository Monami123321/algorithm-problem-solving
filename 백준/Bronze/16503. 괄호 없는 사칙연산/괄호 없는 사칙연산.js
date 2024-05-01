const input = require("fs")
  .readFileSync(0)
  .toString()
  .trim()
  .split(" ");
let forward = cal(cal(+input[0], input[1], +input[2]), input[3], +input[4]);
let reverse = cal(+input[0], input[1], cal(+input[2], input[3], +input[4]));
let ans = "";
[forward, reverse].sort((a, b) => a - b).forEach((e) => (ans += e + "\n"));

console.log(ans);
function cal(a, o, b) {
  switch (o) {
    case "/":
      let res = Math.floor(a / b);
      res = res >= 0 ? res : res + 1;
      return res;
    case "*":
      return a * b;

    case "+":
      return a + b;

    case "-":
      return a - b;
  }
}
