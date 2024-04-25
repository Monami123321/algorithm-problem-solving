let [n, k] =require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
const arr = []
const limit = Math.floor(Math.sqrt(n));
for(let i = 1; i <= limit; ++i) {
    if(n % i === 0) {
        arr.push(i);
        if(n / i !== i) {
            arr.push(n / i);
        }
    }
}

if(arr.length < k) {
    console.log(0)
    return;
}
arr.sort((a,b) => a - b);
console.log(arr[k-1]);
