console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1).map(BigInt)
    .reduce((total, now) => total * now , 1n).toString());