const input = require('fs').readFileSync(0).toString().trim().split("\n").slice(1);
const arr = [];
input.forEach(e=> {
    arr.push(e.split(" ").map(Number))
});
let ans = "";
arr.sort((a,b)=> {
    if(a[1] !== b[1]) {
        return a[1] - b[1];
    }
    return a[0] - b[0];
}).forEach(el => {
    ans += el.join(" ") + "\n";
});
console.log(ans);