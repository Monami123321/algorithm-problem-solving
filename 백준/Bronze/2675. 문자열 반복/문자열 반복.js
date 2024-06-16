const input = require('fs').readFileSync(0).toString().trim().split("\n").slice(1);
let ans = "";
input.forEach(e => {
    let arr = e.split(" ");
    let n = +arr[0];
    ans += arr[1].split("").map(e => e.repeat(n)).join("") + "\n";
});
console.log(ans);
