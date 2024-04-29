const input = require('fs').readFileSync(0).toString().trim().split("\n").slice(1)
let ans = ""
input.forEach(e => {
    let arr = e.split(" ")
    ans += comb(+arr[1], +arr[0]).toString() + "\n"
})
console.log(ans)


function comb(n, r) {
    let res = BigInt(1);
    let multiple = n;
    let divisor = r;
    while(divisor-- >= 1) {
        res *= BigInt(multiple--);
    }
    divisor = 1
    while(divisor++ < r) {
        res /= BigInt(divisor);
    }
    return res;
}