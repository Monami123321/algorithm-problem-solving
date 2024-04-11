const [m,k] = require('fs').readFileSync("/dev/stdin").toString().trim().split(" ").map(Number)
if(m % k === 0) {
    console.log("Yes")
} else {
    console.log("No")
}