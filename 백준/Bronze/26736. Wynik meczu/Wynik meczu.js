let a = 0;
let b = 0;
require('fs').readFileSync(0).toString().trim().split("").forEach(e => {
    if(e === 'A') {
        a++;
    } else {
        b++;
    }
});
console.log(`${a} : ${b}`);