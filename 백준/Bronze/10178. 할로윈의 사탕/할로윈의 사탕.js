console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1).map(e=> {
    let [a, b] = e.split(" ").map(Number);
    let c = Math.floor(a / b);
    let d = a % b;
    return `You get ${c} piece(s) and your dad gets ${d} piece(s).`;
}).join("\n"));