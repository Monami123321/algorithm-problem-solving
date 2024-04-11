let n = +require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim();
let arr = [-1, 1, 0, 1, 0];
for (let index = 5; index <= n; index++) {
  if (arr[index - 1] === 0 && arr[index - 3] === 0) {
    arr.push(1);
  } else if (arr[index - 1] === 1 && arr[index - 3] === 1) {
    arr.push(0);
  } else {
    arr.push(0);
  }
}
if (arr[n] === 0) {
  console.log("SK");
} else {
  console.log("CY");
}
