let n = +require('fs').readFileSync(0);
for(let i = 1; i <= n; ++i) {
    if(getVal(i) == n) {
        console.log(i);
        return;
    }
}
console.log(0);

function getVal(n) {
    let res = n;
    while(n > 0) {
        res += n % 10;
        n = Math.floor(n / 10);
    }
    return res;
}
