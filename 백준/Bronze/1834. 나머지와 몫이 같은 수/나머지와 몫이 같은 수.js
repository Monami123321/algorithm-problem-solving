let n = +require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt').toString().trim()
let ans = 0n
for(let i = 1; i<n; i++) {
    ans += BigInt(n*i) + BigInt(i)
}
console.log(ans.toString())
