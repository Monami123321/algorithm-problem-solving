const input = require('fs').readFileSync(0).toString().trim().split("\n");
input.forEach(e => {
    const [a,b] = e.split(" ").map(Number);
    if(a === 0) {
        return;
    }
    if(b % a === 0) {
    console.log("factor");
    } else if(a % b === 0) {
    console.log("multiple");
    } else {
    console.log("neither");
    }
})
