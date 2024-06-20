let [a, b] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
if(a <= 11 || a > 16 || b === 1) {
    console.log(280);
} else {
    console.log(320);
}