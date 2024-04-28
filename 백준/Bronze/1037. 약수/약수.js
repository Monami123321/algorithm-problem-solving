let [n,arr] = require('fs').readFileSync(0).toString().trim().split("\n");
arr = arr.split(" ").map(Number).sort((a,b) => a - b);
console.log(arr[0] * arr.pop());