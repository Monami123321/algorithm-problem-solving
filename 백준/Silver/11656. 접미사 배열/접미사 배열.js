let word = require('fs').readFileSync(0).toString().trim();
const arr = [];
for(let i = 0; i < word.length; ++i) {
    arr.push(word.slice(i));
}
console.log(arr.sort().join("\n"));