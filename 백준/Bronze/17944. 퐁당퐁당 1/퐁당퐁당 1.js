let [n, t] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
let divisor = (n << 2) - 2;
t %= divisor;
if(t == 0) {
    t = divisor;
}
let flag = false;
if(t >= n << 1) {
    t -= (n << 1);
    flag = true;
}
if(flag) {
    console.log( (n << 1) - t)    
} else {
    console.log(t)
}

