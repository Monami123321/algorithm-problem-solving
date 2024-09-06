let input = require('fs').readFileSync(0).toString().trim().split("\n");
let [n, m] = input[0].split(" ").map(Number);
if(n === 0) {
    console.log(0);
    return;
}
const arr = input[1].split(" ").map(Number);
let now = 0;
let cnt = 1;
arr.forEach(e => {
    now += e;
    if(now > m) {
        cnt++;
        now = e;
    }
});
console.log(cnt);