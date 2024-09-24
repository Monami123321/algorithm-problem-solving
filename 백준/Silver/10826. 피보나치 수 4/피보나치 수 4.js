let k = +require('fs').readFileSync(0);
const arr = [0n, 1n, 1n];
for(let i = 3; i <= k; ++i) {
    arr.push(arr[i - 1] + arr[i - 2]);
}
console.log(arr[k].toString());