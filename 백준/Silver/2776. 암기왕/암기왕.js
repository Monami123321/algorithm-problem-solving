const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let tc = +input[0];
let index = 1;
let ans = "";
while (tc-- > 0) {
  index++;
  let set1 = new Set(input[index++].split(" ").map(Number));
  index++;
  let set2 = input[index++].split(" ").map(Number);

  set2.forEach((e) => {
    if (set1.has(e)) {
      ans += 1 + "\n";
    } else {
      ans += 0 + "\n";
    }
  });
}
console.log(ans.substring(0,ans.length-1));
