const input = require('fs').readFileSync(0).toString().trim();
const len = input.length;
let ans = input.substring(0,input.indexOf("(")).split("").reduce((prev, now) => {
    if(now === "@") {
        return prev+1;
    }
    return prev;
},0) + " "
ans += input.substring(input.indexOf(")")+1).split("").reduce((prev, now) => {
    if(now === "@") {
        return prev+1;
    }
    return prev;
},0)
console.log(ans)