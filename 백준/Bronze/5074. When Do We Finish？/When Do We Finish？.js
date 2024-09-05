const arr = require('fs').readFileSync(0).toString().trim().split("\n").map(e=> e.split(" "));
arr.pop();
console.log(arr.map(e=> {
    let start = getNum(e[0]);
    let dur = getNum(e[1]);
    let next = start + dur;
    let n = Math.floor(next / (60 * 24));
    next -= n * 60 * 24;
    let t = getTime(next);
    if (n !== 0) {
        t += ` +${n}`;
    }
    return t;
}).join("\n"));



function getNum(t) {
    return parseInt(t.substring(0,2))*60 + parseInt(t.substring(3));
}

function getTime(n) {
    let h = Math.floor(n / 60);
    let m = n - h * 60;
    
    if(h < 10) {
        h = "0" + h;
    }
    
    if(m < 10) {
        m = "0" + m;
    }
    return `${h}:${m}`;
}
