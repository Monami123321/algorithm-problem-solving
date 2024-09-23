let [a, b] = require('fs').readFileSync(0).toString().split(" ").map(Number);
console.log(b / getGCD(a,b) * a);
function getGCD(a, b) {
    let tmp;
    while(b !== 0) {
        tmp = a % b;
        a = b;
        b = tmp;
    }
    return a;
}