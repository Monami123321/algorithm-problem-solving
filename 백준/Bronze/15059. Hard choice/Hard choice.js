console.log(require('fs').readFileSync(0).toString().trim().split("\n").map(e => e.split(" ").map(Number)).reduce((total, now) => {
    let cnt = 0;
    for(let i = 0; i < 3; ++i) {
        cnt += total[i] - now[i] < 0 ? now[i] - total[i] : 0;
    }
    return cnt;
}));
