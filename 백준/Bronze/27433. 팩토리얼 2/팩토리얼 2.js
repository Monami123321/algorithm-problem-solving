let n = +require('fs').readFileSync(0);
let res = 1n;
while (n > 1) {
    res *= BigInt(n--);
}
console.log(res.toString())