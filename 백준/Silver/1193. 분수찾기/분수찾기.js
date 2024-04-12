let x = +require("fs").readFileSync(
  process.platform === "linux" ? "/dev/stdin" : "./input.txt"
);

let n = Math.floor(Math.sqrt(x << 1));
while ((n * (n + 1)) / 2 > x) {
  n--;
}
x -= (n * (n + 1)) / 2;

if (x == 0) {
  if ((n & 1) === 0) {
    console.log(n + "/" + 1);
  } else {
    console.log(1 + "/" + n);
  }
} else {
  if (((n + 1) & 1) === 0) {
    console.log(x + "/" + (n + 2 - x));
  } else {
    console.log(n + 2 - x + "/" + x);
  }
}
