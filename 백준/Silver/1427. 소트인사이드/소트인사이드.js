let ans = "";
require('fs').readFileSync(0).toString().trim().split("").sort((a,b) => +b - +a).forEach(e=> {
    ans += e;
});
console.log(ans)