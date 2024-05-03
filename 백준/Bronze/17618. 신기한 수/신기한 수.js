let n = +require('fs').readFileSync(0).toString();
let ans = 0;
while(n > 0) {
    if(isPossible(n--)) {
        ans++;
    }
}
console.log(ans)

function isPossible(n) {
    return n % n.toString().split("").reduce((total,now) =>total + +now,0) === 0;
}