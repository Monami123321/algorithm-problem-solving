const fs = require('fs')
const filePath = process.platform ==="linux" ? "/dev/stdin" : "./input.txt"
const [n,m] = fs.readFileSync(filePath).toString().trim().split(" ").map(Number)
let gcd = getGCD(n,m)
console.log(gcd)
console.log(n*m/gcd)


function getGCD(a,b) {
    while(b !=0) {
        let tmp = a % b;
        a = b;
        b = tmp;
    }
    return a;
}