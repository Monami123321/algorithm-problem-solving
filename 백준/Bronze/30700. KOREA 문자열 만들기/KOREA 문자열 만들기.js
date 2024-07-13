let word = ["K", "O", "R", "E", "A"];
let arr = require('fs').readFileSync(0).toString().trim().split("");
let index = 0;
let pt = 0;
let len = 0;
while(pt < arr.length) {
    if(arr[pt++] === word[index]) {
        index = (index + 1) % 5;
        len++;
    }
}
console.log(len);
