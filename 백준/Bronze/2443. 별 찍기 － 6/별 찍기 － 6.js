let n = +require('fs').readFileSync(0);
let star = "*".repeat((n << 1 ) - 1).split("");
let index = 0;
let ans = star.join("") + "\n";
while(index < n - 1) {
    star[0 + index] = " ";
    star[star.length - 1 - index++] = "";
    ans += star.join("") + "\n";
}
console.log(ans);