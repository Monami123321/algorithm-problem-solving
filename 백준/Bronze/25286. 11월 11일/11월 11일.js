let month = [31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
let leapMonth = [31, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
console.log(
  require("fs")
    .readFileSync(0)
    .toString()
    .trim()
    .split("\n")
    .slice(1)
    .map((e) => {
      let arr = e.split(" ").map(Number);
      let flag = check(arr[0]);
      let day = flag ? leapMonth[arr[1] - 1] : month[arr[1] - 1];
      if (arr[1] === 1) {
        return `${arr[0] - 1} 12 ${day}`;
      }
      return `${arr[0]} ${arr[1] - 1} ${day}`;
    })
    .join("\n")
);

function check(year) {
  if (year % 400 === 0) {
    return true;
  }
  if (year % 100 === 0) {
    return false;
  }

  if (year % 4 === 0) {
    return true;
  }
  return false;
}
