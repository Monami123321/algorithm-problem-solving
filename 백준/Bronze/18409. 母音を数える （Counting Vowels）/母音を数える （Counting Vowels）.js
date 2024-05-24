const input = require('fs').readFileSync(0).toString().split("\n");
const set = new Set(["a","e","i","o","u"]);
console.log(input[1].trim().split("").reduce( (total, now) => {
    if(set.has(now)) {
        return total + 1;
    }
    return total;
},0));