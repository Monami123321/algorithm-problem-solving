const n = +require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : "./input.txt").toString().trim()
const MOD = 15746
let arr = new Array(n+1).fill(0)
arr[1] = 1
arr[2] = 2
for(let i = 3; i<= n; i++) {
    arr[i] = (arr[i-1] + arr[i-2]) % MOD
}
console.log(arr[n])
