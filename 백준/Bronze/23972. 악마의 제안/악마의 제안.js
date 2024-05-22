let[k, n] = require('fs').readFileSync(0).toString().split(" ").map(Number);
if(n === 1) {
    console.log(-1);
} else {
    let multiple = BigInt(k) * BigInt(n);
    if(multiple % BigInt(n-1) === 0n) {
        console.log((multiple / BigInt(n-1)).toString());
    } else {
        console.log((multiple / BigInt(n-1) + 1n).toString());
    }
}