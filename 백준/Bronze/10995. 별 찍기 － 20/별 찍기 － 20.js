let n = +require('fs').readFileSync(0);
let str = "* ".repeat(n);
let ans = "";
for(let i = 0; i < n; ++i) {
    if((i & 1) === 0) {
        ans += `${str}\n`;
    } else {
        ans += ` ${str}\n`;
    }
}
console.log(ans);