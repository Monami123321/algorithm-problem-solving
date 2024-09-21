console.log(require('fs').readFileSync(0).toString().trim().split("\n")
    .map(e => {
    let n = +e;
    let k = binSearch(n << 1);
    let diff = n - ((k * (k - 1)) >> 1) - 1;
    let num;
    let div;
    let sign;
    if((k & 1) === 0) {
        num = 1;
        div = k;
        sign = 1;
    } else {
        num = k;
        div = 1;
        sign = -1;
    }
    return `TERM ${e} IS ${num + diff * sign}/${div - diff * sign}`;
}).join("\n"));

function binSearch(n) {
    let start = 1;
    let end = 5000;
    while(start <= end) {
        let mid = start + end >> 1;
        let val = mid * (mid + 1);
        
        if(n <= val) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return start;
}