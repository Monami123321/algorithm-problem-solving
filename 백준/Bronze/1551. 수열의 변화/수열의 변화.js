const input = require('fs').readFileSync(0).toString().trim().split("\n");
let [n, k] = input[0].split(" ").map(Number);
let arr = input[1].split(",").map(Number);
while(k-- > 0) {
    for(let i = 0; i < n - 1; ++i) {
        arr[i] = arr[i + 1] - arr[i]; 
    }
    n--;
}
console.log(arr.slice(0, n).join(","));