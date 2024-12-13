let [a, b] = require('fs').readFileSync(0).toString().split(" ").map(Number);
let target = a + b;
let limit = Math.floor(Math.sqrt(target));
for(let i = 1; i<=limit; ++i) {
    if(target % i === 0) {
       let big = Math.floor(target / i);
        if((i + big << 1) === a + 4) {
            console.log(`${big} ${i}`);
            return;
        }
    }
}