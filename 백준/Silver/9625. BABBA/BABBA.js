let k = require('fs').readFileSync(0);
let a = 1;
let b = 0;
let prevA;
let prevB;
while(k-- > 0) {
    prevA = a;
    prevB = b;
    a = prevB;
    b = prevB + prevA;
}
console.log(`${a} ${b}`);