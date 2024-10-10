let n = +require('fs').readFileSync(0);
let arr = new Array(n + 1).fill(0).map((e, i) => n - i);
for(let i = n; i >= 2; --i) {
    if(i % 3 === 0) {
        arr[i / 3] = Math.min(arr[i / 3], arr[i] + 1);
    }
    
    if((i & 1) === 0) {
        arr[i >> 1] = Math.min(arr[i >> 1], arr[i] + 1);
    }
    arr[i - 1] = Math.min(arr[i - 1], arr[i] + 1);
} 
console.log(arr[1]);