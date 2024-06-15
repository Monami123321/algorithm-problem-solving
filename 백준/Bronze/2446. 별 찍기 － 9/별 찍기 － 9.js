let n = +require('fs').readFileSync(0);
let s = n;
let m = 0;
let ans = "";
while(s > 0) {
    ans += " ".repeat(m++);
    ans += "*".repeat((s-- << 1) - 1) + "\n";
}
s++;
m--;
while(s < n) {
    ans += " ".repeat(--m);
    ans += "*".repeat((++s << 1) - 1) + "\n";
}
console.log(ans);
