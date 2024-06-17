console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1).map(e=> {
    return `$${e.split(" ").reduce((total, now) => total * +now, 1).toFixed(2)}\n`;
}).join(""));