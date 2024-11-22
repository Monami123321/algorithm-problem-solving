let [n, ...arr] = require('fs').readFileSync(0).toString().trim().split("\n");
let index = 1;
console.log(arr.map(e => `${index++}. ${e}`).join("\n"));