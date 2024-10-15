let [[n, m], arr] = require('fs').readFileSync(0).toString().trim().split("\n").map(e => e.split(" ").map(Number));
let diff = 1 << 30;
let ans = 0;
for(let i = 0; i < n - 2; ++i) {
    for(let j = i + 1; j < n - 1; ++j) {
        for(let k = j + 1; k < n; ++k) {
            let sum = arr[i] + arr[j] + arr[k];
            if(sum <= m && m - sum < diff) {
                ans = sum;
                diff = m - sum;
            }
        }
    }
}
console.log(ans);