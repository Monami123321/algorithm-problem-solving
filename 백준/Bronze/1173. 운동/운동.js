let [N, m, M, T, R] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
if(m + T > M) {
    console.log(-1);
} else {
    let t = 0;
    let now = m;
    
    while(N > 0) {
        if(now + T > M) {
            now = Math.max(m, now - R);
        } else {
            now += T;
            --N;
        }
        ++t;
    }
    console.log(t);
}