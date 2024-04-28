const input = require('fs').readFileSync(0).toString().trim().split("\n")
let ans = ""
input.shift();
input.forEach(e => {
    let isCorrect = 1;
    let cnt = 1;
    let arr = e.trim().split("");
    let len = arr.length;
    for(let i = 0; i < len >> 1; i++) {
        if(arr[i] !== arr[len-1-i]) {
            isCorrect = 0;
            break;
        }
        cnt++;
    }
    ans += isCorrect + " " + cnt + "\n"
});
console.log(ans)