let [a, b] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
while(a-- > 1) {
    b >>= 1;
}
console.log(b);