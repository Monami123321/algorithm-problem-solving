let n = +require('fs').readFileSync(0);
const arr = new Array(n + 1).fill(0);
arr[1] = arr[2] = 1;
for(let i = 3; i <= n; ++i) {
    arr[i] = arr[i - 2] + arr[i - 1];
}
console.log(`${arr[n]} ${n-2}`);