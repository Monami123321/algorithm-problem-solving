const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
const n = +input[0];
let arr = new Array(n)
  .fill(0)
  .map((e, index) => {
    return input[index + 1].split(" ");
  })
  .sort(getOrder);
console.log(`${arr[n-1][0]}\n${arr[0][0]} `)

function getOrder(a, b) {
  if (+a[3] > +b[3]) {
    return 1;
  } else if (+b[3] > +a[3]) {
    return -1;
  } else {
    if (+a[2] > +b[2]) {
      return 1;
    } else if (+b[2] > +a[2]) {
      return -1;
    } else {
      if (+a[1] > +b[1]) {
        return 1;
      } else {
        return -1;
      }
    }
  }
}
