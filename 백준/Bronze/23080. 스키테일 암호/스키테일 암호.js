let [k, s] = require('fs').readFileSync(0).toString().split("\n");
k = +k;
s = s.trim();
let ans = "";
for(let i = 0; i < s.length; i += k) {
    ans += s[i];
}
console.log(ans);

