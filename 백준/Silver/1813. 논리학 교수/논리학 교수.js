const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt').toString().trim().split("\n")
let cnt = new Array(51).fill(0)
input[1].split(" ").map(Number).forEach(e => cnt[e]++)
for(let i = 50; i>=0; i--) {
    if(cnt[i] == i) {
        console.log(i)
        return;
    }
}
console.log(-1)

