const input = require('fs').readFileSync(0).toString().trim();
let index = 0;
let cnt = 0;
while(index < input.length) {
    if(input.charAt(index++) === " ") {
        cnt++;
    }
}

console.log(index === 0 ? 0 : cnt + 1);