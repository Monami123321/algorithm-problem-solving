let input = require('fs').readFileSync(0).toString().trim().split("\n");
let tc = +input[0];
let index = 1;
let ans = "";
while(tc-- > 0) {
    let n = +input[index++];
    ans += input.slice(index, index + n).map(e => e.split(" ")).sort((a, b) => +b[1] - +a[1])[0][0] + "\n";
    index += n;
}
console.log(ans);