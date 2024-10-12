console.log(require('fs').readFileSync(0).toString().trim().split("\n").map(e => e.split(" "))
    .sort((a, b) => +b[1] - +a[1])[0][0]);