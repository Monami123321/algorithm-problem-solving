let sum = 0;
let ans = [];
require('fs').readFileSync(0).toString().split("\n").map((e,i) => [+e, i + 1])
    .sort((a, b) => b[0] - a[0]).slice(0, 5).forEach(e => {
    sum += e[0];
    ans.push(e[1]);
});
console.log(`${sum}\n${ans.sort((a, b) => a - b).join(" ")}`);