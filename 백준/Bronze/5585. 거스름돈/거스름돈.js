let n = 1000 - +require('fs').readFileSync('/dev/stdin').toString().trim();
let arr = [500,100,50,10,5,1]
let ans = 0;
arr.forEach(e => {
    ans += Math.floor(n/e);
    n %= e;
})
console.log(ans)


