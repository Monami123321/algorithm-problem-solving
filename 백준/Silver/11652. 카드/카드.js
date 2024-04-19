const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(BigInt)
const len = input[0].valueOf();
const hm = new Map();
for (let i = 1; i <= len; i++) {
  let now = hm.get(input[i]);
  if (!now) {
    hm.set(input[i], 1);
  } else {
    hm.set(input[i], now + 1);
  }
}
const arr = Array.from(hm).sort((a, b) => {
  if (a[1] !== b[1]) {
    return b[1] - a[1];
  }
  if(a[0] > b[0]) {
    return 1
  } else {
    return -1
  }
  
});
console.log(arr[0][0].toString());
