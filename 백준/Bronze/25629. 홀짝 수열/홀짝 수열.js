const input = require('fs').readFileSync(0).toString().trim().split("\n");
let even = 0;
let odd = 0;
input[1].split(" ").map(Number).forEach(e => {
    if((e & 1) == 0) {
        even++;
    } else {
        odd++;
    }
});
if(even > odd || odd - even > 1) {
    console.log(0);
} else {
    console.log(1);
}