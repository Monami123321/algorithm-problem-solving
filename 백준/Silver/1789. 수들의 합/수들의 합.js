let x = +require('fs').readFileSync(process.platform === "linux" ? '/dev/stdin' : './input.txt')

let n = Math.floor(Math.sqrt(x * 2))-1
while((n * (n+1)) /2  <= x) {
    n++;
}
console.log(n-1)



