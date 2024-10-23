let n = +require('fs').readFileSync(0);
let arr = new Array(n + 1).fill(0);
arr[1] = arr[2] = 1n;
console.log(fibo(n).toString());

function fibo(n) {
    if(arr[n] !== 0) {
        return arr[n];
    }
    return arr[n] = fibo(n - 1) + fibo(n - 2);
}