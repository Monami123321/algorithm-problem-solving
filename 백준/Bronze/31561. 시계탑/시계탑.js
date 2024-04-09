const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let m = parseInt(fs.readFileSync(filePath).toString().trim());
if (m <= 30) {
  m /= 2;
} else {
  let diff = m - 30;
  m = 15 + (diff * 3) / 2;
}
console.log(m.toFixed(1));
