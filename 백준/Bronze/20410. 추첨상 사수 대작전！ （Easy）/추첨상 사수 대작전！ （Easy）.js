let [m, s, x1, x2] = require('fs').readFileSync(0).toString().split(" ").map(Number);
for(let i = 0; i < m; i++) {
    for(let j = 0; j < m; j++) {
        if(x1 === (i * s + j) % m && x2 === (i * x1 + j) % m) {
            console.log(`${i} ${j}`);
            return;
        }
    }
}