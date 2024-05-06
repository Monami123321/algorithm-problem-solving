let [a, b] =require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
a -= 2;
let now = 1;
let ans = 0;
for(let i = 0; i <= b; ++i) {
    ans += now;
    now += a;
}
console.log(ans);