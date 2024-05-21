const input = require('fs').readFileSync(0).toString().split("\n");
let arr = input.shift().split(" ").map(Number);
let n = +input.shift();
let ans = 0;
for(let i = 0; i < n; ++i) {
    let sum = 0;
    for(let j = 0; j < 3; ++j) {
        sum += input.shift().split(" ").map(Number).reduce((total, now, index) => {
            return total + now * arr[index];
        }, 0);
    }
    ans = Math.max(ans, sum);
}
console.log(ans);
