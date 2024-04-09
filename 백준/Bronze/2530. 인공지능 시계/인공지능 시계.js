const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const arr = input[0].split(" ").map(Number);
let time = arr[0] * 3600 + arr[1] * 60 + arr[2];
time += parseInt(input[1]);

const hour = Math.floor(time / 3600) % 24
const minute = Math.floor((time - hour * 3600) / 60) % 60
const second = (time - hour * 3600 - minute * 60) % 60

console.log(hour + " " + minute + " " + second)
