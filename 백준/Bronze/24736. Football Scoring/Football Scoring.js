console.log(require('fs').readFileSync(0).toString().trim().split("\n").map(e => {
    let arr = e.split(" ").map(Number);
    return arr[0] * 6 + arr[1] * 3 + arr[2] * 2 + arr[3] + arr[4] * 2;
}).join(" "));