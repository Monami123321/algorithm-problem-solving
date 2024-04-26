const input =require('fs').readFileSync(0).toString().trim().split("\n")
let arr = [0, 0]
input[1].split(" ").forEach(e => ++arr[(parseInt(e) & 1)])
console.log(arr[0] > arr[1] ? "Happy" : "Sad")