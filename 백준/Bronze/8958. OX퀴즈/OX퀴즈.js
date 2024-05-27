const input = require('fs').readFileSync(0).toString().trim().split("\n").slice(1);
let ans = "";
input.forEach(e => {
    let index = 0;
    let sum = 0;
    let cnt = 0;
    while(index < e.length) {       
        if(e[index++] === "O") {
            sum += ++cnt;
        } else {
            cnt = 0;
        }
    }
    ans += sum + "\n";
});
console.log(ans);