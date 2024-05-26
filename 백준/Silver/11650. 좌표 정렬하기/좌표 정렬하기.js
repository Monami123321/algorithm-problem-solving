const input = require('fs').readFileSync(0).toString().trim().split("\n").slice(1);
const arr = [];
input.forEach(e => {
    arr.push(e.split(" ").map(Number));
});
let ans = "";
arr.sort((a,b)=> {
    if(a[0] === b[0]) {
        return a[1] - b[1];
    }
    return a[0] - b[0];
}).forEach(e => {
    ans += e[0] + " " + e[1] + "\n";
});
console.log(ans);
