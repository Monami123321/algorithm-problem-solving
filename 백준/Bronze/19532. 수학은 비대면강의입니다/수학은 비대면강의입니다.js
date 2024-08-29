let [a,b,c,d,e,f] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);

for(let i = -999; i < 1000; ++i) {
    for(let j = -999; j < 1000; ++j) {
        if(a * i + b * j == c && d * i + e * j == f) {
            console.log(`${i} ${j}`);
            return;
        }
    }
}