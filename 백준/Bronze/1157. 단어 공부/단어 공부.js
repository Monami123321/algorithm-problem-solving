let arr = new Array(26).fill(0);
require('fs').readFileSync(0).toString().trim().toLowerCase().split("").forEach(e =>arr[e.charCodeAt(0) - 97]++);
let max = 0;
for(let i = 0; i < 26; ++i) {
    max = Math.max(max,arr[i]);
}
let ans = -1;
for(let i = 0; i < 26; ++i) {
    if(arr[i] === max) {
        if(ans !== -1) {
            ans = "?";
            break;
        }
        ans = String.fromCharCode(i + 65);
    }
}
console.log(ans);


