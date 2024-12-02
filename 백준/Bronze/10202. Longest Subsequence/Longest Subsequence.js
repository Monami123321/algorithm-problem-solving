let [tc, ...arr] = require('fs').readFileSync(0).toString().trim().split("\n");
console.log(arr.map(e => {
    let [len, ...tmp] = e.split(" ");
    len = +len;
    let cnt = tmp[0] === "X" ? 1 : 0;
    let res = 0;
    for(let i = 1; i < len; ++i) {
        if(tmp[i] === "X") {
            cnt++;
        } else {
            res = Math.max(res, cnt);
            cnt = 0;
        }
    }
    res = Math.max(res, cnt);
    return `The longest contiguous subsequence of X's is of length ${res}`;
}).join("\n"));