let [a, b] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
let left = -a + Math.sqrt(a * a - b);
let right = -a - Math.sqrt(a * a - b);
if(left === right) {
    console.log(left);
} else {
    console.log(`${right} ${left}`);
}
