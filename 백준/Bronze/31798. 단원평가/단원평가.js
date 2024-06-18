let [a, b, c] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
if(a === 0) {
    console.log(c * c - b);
} else if (b === 0) {
    console.log(c * c - a);
} else {
    console.log(Math.sqrt(a + b));
}