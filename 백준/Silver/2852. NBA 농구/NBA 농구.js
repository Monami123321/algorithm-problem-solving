const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let arr = fs.readFileSync(filePath).toString().trim().split("\n");
let n = parseInt(arr[0]);

let score1 = 0;
let score2 = 0;
let time1 = 0;
let time2 = 0;
let flag = 0;
let prev = 0;
for (let i = 1; i < n + 1; i++) {
  const now = arr[i].split(" ");
  let team = parseInt(now[0]);
  if (team === 1) {
    score1++;
  } else {
    score2++;
  }
  let time = getTime(now[1]);
  if (flag === 0) {
    prev = time;
  } else if (flag === 1) {
    if (score1 <= score2) {
      time1 += time - prev;
      prev = time;
    }
  } else {
    if (score1 >= score2) {
      time2 += time - prev;
      prev = time;
    }
  }
  flag = score1 > score2 ? 1 : score1 === score2 ? 0 : 2;
}
let last = 48 * 60;
if (flag === 1) {
  time1 += last - prev;
} else if (flag === 2) {
  time2 += last - prev;
}

let minute1 =
  time1 / 60 < 10 ? "0" + Math.floor(time1 / 60) : Math.floor(time1 / 60);
let second1 = time1 % 60 < 10 ? "0" + (time1 % 60) : time1 % 60;
let minute2 =
  time2 / 60 < 10 ? "0" + Math.floor(time2 / 60) : Math.floor(time2 / 60);
let second2 = time2 % 60 < 10 ? "0" + (time2 % 60) : time2 % 60;
console.log(minute1 + ":" + second1);
console.log(minute2 + ":" + second2);

function getTime(time) {
  let clock = time.split(":");
  const minutes = parseInt(clock[0]) * 60;
  const seconds = parseInt(clock[1]);
  return minutes + seconds;
}
