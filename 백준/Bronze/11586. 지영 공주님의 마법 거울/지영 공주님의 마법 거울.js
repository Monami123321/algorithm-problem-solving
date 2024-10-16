let input = require('fs').readFileSync(0).toString().trim().split("\n");
let n = +input[0];
let arr = input.slice(1, n + 1).map(e => e.trim().split(""));
let k = +input.pop();
let ans = "";
if(k === 1) {
    for(let i = 0; i < n; ++i) {
        for(let j = 0; j < n; ++j) {
            ans += arr[i][j];
        }
        ans += "\n";
    }
} else if (k === 2) {
    for(let i = 0; i < n; ++i) {
        for(let j = n - 1; j >= 0; --j) {
            ans += arr[i][j];
        }
        ans += "\n";
    }
    
} else {
    for(let i = n - 1; i >= 0; --i) {
        for(let j = 0; j < n; ++j) {
            ans += arr[i][j];
        }
        ans += "\n";
    }
}
console.log(ans);
