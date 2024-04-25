let input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);
let ans = "";
input.shift();
input.forEach((e) => {
  e.toString(2)
    .split("")
    .forEach((el, index, arr) => {
      if (el == 1) {
        ans = arr.length - 1 - index + " " + ans;
      }
    });
  console.log(ans);
  ans = "";
});
