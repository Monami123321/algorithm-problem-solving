let n = +require('fs').readFileSync(0);
let base = 10;
while(n > base) {
    let mod = n % base;
    if(mod >= (base >> 1)) {
        n += base;
    }
    n -= mod;
    base *= 10;
}
console.log(n);