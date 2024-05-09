const input = require('fs').readFileSync(0).toString().trim().split("\n");
input.shift();
console.log(input.map((e,index)=> [index + 1, e.split(" ").reduce((total, now) => total + +now * +now, 0)])
    .sort((a,b) => {
    if(a[1] !== b[1]) {
        return b[1] - a[1];
    }
    return a[0]-b[0]
}).map(e=>e[0]).join("\n"));
