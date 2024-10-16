let n = +require('fs').readFileSync(0);
let ref = n << 1;
let ans = "";
let i = 1;
while(i <= n) {
    ans += "*".repeat(i)+ " ".repeat(ref - (i << 1)) + "*".repeat(i) + "\n";
    i++;
}
i--;
while(--i >= 1) {
    ans += "*".repeat(i)+ " ".repeat(ref - (i << 1)) + "*".repeat(i) + "\n";
}
console.log(ans);