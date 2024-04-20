let n = +require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim();

let arr = new Array(n + 1).fill(0);
arr[2] = arr[1] = 1n;
fibo(n);
console.log(arr[n].toString());

function fibo(n) {
  if (arr[n] !== 0) {
    return arr[n];
  }
  return arr[n] = fibo(n - 1) + fibo(n - 2);
}
