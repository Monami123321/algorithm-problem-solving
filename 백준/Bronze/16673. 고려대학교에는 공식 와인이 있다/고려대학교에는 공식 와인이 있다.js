let [c, k, p] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
if(c == 0) {
    console.log(0);
} else {
    console.log(k * ((c * (c+1) ) >> 1) + ( (c * (c + 1) * ( (c << 1) +1) ) / 6) * p);
}
