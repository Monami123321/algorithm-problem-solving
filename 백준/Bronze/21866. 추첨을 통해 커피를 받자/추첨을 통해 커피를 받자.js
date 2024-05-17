let ref = [100, 100, 200, 200, 300, 300, 400, 400, 500];
let arr = require('fs').readFileSync(0).toString().split(" ").map(Number);
let sum = 0;
for(let i = 0; i < 9; ++i) {
    if(arr[i] > ref[i]) {
        console.log("hacker");
        return;
    }
    sum += arr[i];
}
if(sum < 100) {
    console.log("none");
} else {
    console.log("draw");
}