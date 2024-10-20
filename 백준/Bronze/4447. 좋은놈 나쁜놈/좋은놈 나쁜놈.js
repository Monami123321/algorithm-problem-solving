console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1).map(e => {
    let arr = e.trim().toLowerCase().split("");
    let cntG = 0;
    let cntB = 0;
    arr.forEach(el => {
        if(el === "g") {
            cntG++;
        } else if (el === "b") {
            cntB++;
        }
    });
    let res = cntG === cntB ? "NEUTRAL" : cntG > cntB ? "GOOD" : "A BADDY";
    return `${e} is ${res}`;
}).join("\n"));