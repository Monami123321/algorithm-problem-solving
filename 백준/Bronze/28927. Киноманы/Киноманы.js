let [a, b] = require('fs').readFileSync(0).toString().trim().split("\n")
    .map(e => {
    let arr = e.split(" ").map(Number);
    return arr[0] * 3 + arr[1] * 20 + arr[2] * 120;
});
console.log(a > b ? "Max" : a == b ? "Draw" : "Mel");