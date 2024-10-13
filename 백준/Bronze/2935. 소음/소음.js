let [a, b, c] = require('fs').readFileSync(0).toString().trim().split("\n");
if(b.trim() === "+") {
    console.log((BigInt(a) + BigInt(c)).toString());
} else {
    console.log((BigInt(a) * BigInt(c)).toString());
}