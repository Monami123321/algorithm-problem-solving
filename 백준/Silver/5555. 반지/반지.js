let input = require("fs")
  .readFileSync(0)
  .toString()
  .split("\n")
  .map((e) => e.trim());
let word = input.shift();
input.shift();
input = input.map((e) => e.repeat(2));
console.log(
  input.reduce((total, now) => {
    if (now.includes(word)) {
      return total + 1;
    } else {
      return total;
    }
  }, 0)
);
