const input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt")
  .toString()
  .trim()
  .split("\n");
let love = getLove(input.shift());
input.shift();
let ans = "";
let pb = -1;
input.sort().forEach((e) => {
  let tmp = getPb(getLove(e).map((el, index) => el + love[index]));
  if (tmp > pb) {
    ans = e;
    pb = tmp;
  }
});
console.log(ans);
function getLove(name) {
  let l = 0,
    o = 0,
    v = 0,
    e = 0;
  name.split("").forEach((el) => {
    if (el === "L") {
      l++;
    } else if (el === "O") {
      o++;
    } else if (el === "V") {
      v++;
    } else if (el === "E") {
      e++;
    }
  });
  return [l, o, v, e];
}

function getPb(arr) {
  return (
    ((arr[0] + arr[1]) *
      (arr[0] + arr[2]) *
      (arr[0] + arr[3]) *
      (arr[1] + arr[2]) *
      (arr[1] + arr[3]) *
      (arr[2] + arr[3])) %
    100
  );
}
