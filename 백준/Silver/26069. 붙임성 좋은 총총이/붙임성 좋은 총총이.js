const input = require('fs').readFileSync(0).toString().trim().split("\n")
.map(e=>e.split(" "));

let index = 0;
while(1) {
    if(input[index].includes("ChongChong")) {
        break;
    }
    index++;
}

const set = new Set(input[index]);
input.slice(index + 1).forEach(e => {
    if(set.has(e[0]) || set.has(e[1])) {
        set.add(e[0]).add(e[1]);
    }
});
console.log(set.size);