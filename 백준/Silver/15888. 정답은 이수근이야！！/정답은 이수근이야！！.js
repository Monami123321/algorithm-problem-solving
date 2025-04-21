let [a, b, c] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
if(!hasTwoRoot(a,b,c)) {
    console.log("둘다틀렸근");
    return;
} 
console.log(check(a,b,c));

function hasTwoRoot(a, b, c) {
    return b * b  - 4 * a * c > 0;
}

function check(a, b, c) {
    let big = (-b + Math.sqrt((b * b - (4 * a * c)))) /  (a << 1);
    let small = (-b - Math.sqrt((b * b - (4 * a * c)))) /  (a << 1);
    if(Math.floor(big) !== big || Math.floor(small) !== small) {
        return "둘다틀렸근";
    }
    
    if(big < 0 || small < 0 || !isBin(big) || !isBin(small)) {
        return "정수근";
    }
    return "이수근";
}

function isBin(a) {
    if(a < 2) {
        return false;
    }
    while (true) {
        if ((a & 1) == 1) {
            if(a == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            a >>= 1;
        }
    }
    return false;
}