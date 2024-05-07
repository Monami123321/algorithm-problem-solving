const input = require('fs').readFileSync(0).toString().split("\n");
let tc = +input.shift();
let ans = ""
while(tc-- > 0) {
    let [n, m] = input.shift().split(" ").map(Number);
    if(n < 12 || m < 4) {
        ans += -1 + "\n";
    } else {
        ans += (m * 11 + 4) + "\n";
    }
}
console.log(ans);