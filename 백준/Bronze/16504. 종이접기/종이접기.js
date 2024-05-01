const input = require('fs').readFileSync(0).toString().trim().split("\n");
input.shift();
let ans = 0;
input.forEach(e => {
    ans += e.split(" ").map(Number).reduce((total, now) => {
        return total + now;
    },0);
});
console.log(ans)