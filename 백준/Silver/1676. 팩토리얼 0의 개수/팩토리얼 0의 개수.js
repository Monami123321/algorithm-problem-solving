let n = +require('fs').readFileSync(0);
let cnt = 0;
for(let i = 5; i <= n; i += 5) {
    let now = i;
    while (now % 5 === 0) {
        cnt++;
        now = Math.floor(now / 5);
    }
}
console.log(cnt);