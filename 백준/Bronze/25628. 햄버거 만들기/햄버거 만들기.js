const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split(" ");

let burn = parseInt(input[0]) >> 1;
let meat = parseInt(input[1]);
console.log(burn > meat ? meat : burn);
