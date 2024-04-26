console.log(require('fs').readFileSync(0).toString().trim().split(" ").reduce((prev, now) => {
    return prev + BigInt(now);
},0n).toString());