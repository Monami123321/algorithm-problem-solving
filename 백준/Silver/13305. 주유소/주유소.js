let [n, roads, prices] = require('fs').readFileSync(0).toString().trim().split("\n");
n = +n;
roads = roads.split(" ").map(BigInt);
prices = prices.split(" ").map(BigInt);
let ans = 0n;
let min = prices[0];
for(let i = 0; i < n - 1; ++i) {
    ans += min * roads[i];
    min = min < prices[i + 1] ? min : prices[i + 1];
}
console.log(ans.toString());