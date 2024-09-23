let [h, y] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
let arr = new Array(y + 1).fill(0);
arr[0] = h;

for(let i = 1; i <= y; ++i ) {
    arr[i] = Math.floor(arr[i - 1] * 1.05);
    if(i >= 3) {
        arr[i] = Math.max(arr[i], Math.floor(arr[i - 3] * 1.2));
    }
    if(i >= 5) {
        arr[i] = Math.max(arr[i], Math.floor(arr[i - 5] * 1.35));
    }
}
console.log(arr[y]);
