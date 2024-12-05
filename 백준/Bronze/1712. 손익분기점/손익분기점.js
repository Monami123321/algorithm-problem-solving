let [a,b,c] = require('fs').readFileSync(0).toString().split(" ").map(Number);
if(b >= c) {
    console.log(-1);
    return;
}
console.log(a % (c - b) === 0 ? a / (c - b) +1 : Math.ceil(a / (c - b)));