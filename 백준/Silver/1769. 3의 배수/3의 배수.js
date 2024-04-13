const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim();

if (input.length === 1) {
  console.log(0);
  if (parseInt(input) % 3 === 0) {
    console.log("YES");
  } else {
    console.log("NO");
  }
  return;
}

let n = 0;
for (let i = 0; i < input.length; i++) {
  n += parseInt(input.charAt(i));
}
let cnt = 1;
while (n > 9) {
  let sum = 0;
  while (n > 0) {
    sum += n % 10;
    n = Math.floor(n / 10);
  }
  n = sum;
  cnt++;
}
console.log(cnt);
if (n % 3 === 0) {
  console.log("YES");
} else {
  console.log("NO");
}
