const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim();

let index = input.length;
let ans = "";
while (index > 0) {
  let start = index -3 >=0 ? index-3 : 0  
  ans = parseInt(input.slice(start, index), 2).toString(8) + ans;
  index -= 3;
}
console.log(ans)
