const input = require('fs').readFileSync(0).toString().trim().split("\n");
let ans = "";
let n = +input[0];
let index = 1;
while(n-- > 0) {
    let len = +input[index++];
    ans += input.slice(index, index + len).map(e=> e.split(" ")).sort((a, b) => +b[0] - +a[0])[0][1].trim() + "\n";
    index += len;
}
console.log(ans);

