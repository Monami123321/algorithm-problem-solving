let input = require('fs').readFileSync(0).toString().trim().split("\n");
let index = 0;
let arr = [];
let ans = [];
while(input[index] !== '0') {
    let n = +input[index++];
    for(let i = 0; i < n; ++i) {
        arr.push(input[index++]);
    }
    n = +input[index++];
    for(let i = 0; i < n; ++i) {
        arr.push(input[index++].trim());
    }
    ans.push(arr.sort((a,b)=> {
        if(a.charAt(0) !== b.charAt(0)) {
            return b.charCodeAt(0) - a.charCodeAt(0);
        }
        return a.charCodeAt(1) - b.charCodeAt(1);
    }).join(" "));
    arr = [];
}
console.log(ans.join("\n"));