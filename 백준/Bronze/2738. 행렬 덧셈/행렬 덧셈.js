const input = require('fs').readFileSync(0).toString().trim().split("\n");
let [n, m] = input.shift().split(" ").map(Number);
let arr = new Array(n).fill(0).map(e => new Array(m).fill(0));
for(let i = 0; i < n; ++i) {
    arr[i] = input.shift().split(" ").map(Number);
}
input.forEach((e, idx) => {
    e.split(" ").map(Number).forEach((el,index) => {
        arr[idx][index] += el;
    });
});
let ans = "";
arr.forEach(e => {
    ans += e.join(" ") + "\n";
});
console.log(ans);

