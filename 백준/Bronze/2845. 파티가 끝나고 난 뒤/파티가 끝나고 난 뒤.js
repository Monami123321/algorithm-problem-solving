const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
let arr = input[0].split(" ").map((e) => parseInt(e));

const num = arr[0] * arr[1];
arr = input[1].split(" ").map(e => parseInt(e));
let ans = ""
arr.forEach(e => {
    ans += (e-num)+" "
})
console.log(ans)
