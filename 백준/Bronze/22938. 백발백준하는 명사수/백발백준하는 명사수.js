const input = require('fs').readFileSync(0).toString().split("\n");
let [x1, y1, r1] = input[0].split(" ").map(Number);
let [x2, y2, r2] = input[1].split(" ").map(Number);
let dist = Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2);
if(dist >= Math.pow(r1 + r2, 2)) {
    console.log("NO");
} else {
    console.log("YES");
}