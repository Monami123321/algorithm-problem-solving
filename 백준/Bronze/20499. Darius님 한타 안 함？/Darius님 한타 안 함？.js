const [k, d, a] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("/")
  .map(Number);
if (k + a < d || d === 0) {
  console.log("hasu");
} else {
  console.log("gosu");
}
