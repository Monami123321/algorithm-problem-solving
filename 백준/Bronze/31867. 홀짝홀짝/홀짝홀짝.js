let even = 0;
let odd = 0;
require('fs').readFileSync(0).toString().trim().split("\n")[1].split("").forEach(e=> {
    if((+e & 1) === 0) {
        ++even;
    } else {
        ++odd;
    }
});
let ans = -1;
if(even > odd) {
    ans = 0;
} else if (odd > even) {
    ans = 1;
}
console.log(ans);