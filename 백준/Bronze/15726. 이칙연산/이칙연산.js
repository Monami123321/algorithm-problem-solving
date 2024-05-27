let [a, b, c] =require('fs').readFileSync(0).toString().split(" ").map(Number);
if(a * b / c > a / b * c) {
    console.log(Math.floor(a * b / c));
} else {
    console.log(Math.floor(a / b * c));
}
