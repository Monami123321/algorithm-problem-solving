console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1)
    .map((e, index) => {
    let n = +e;
    let r = "";
    if(e <= 25) {
        r = "World Finals";
    } else if (e <= 1000) {
        r = "Round 3";
    } else if (e <= 4500) {
        r = "Round 2";
    } else {
        r = "Round 1";
    }
    return `Case #${index+1}: ${r}`
}).join("\n"));


