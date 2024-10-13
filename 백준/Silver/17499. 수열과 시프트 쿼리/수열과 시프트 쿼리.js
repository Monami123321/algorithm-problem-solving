let input = require('fs').readFileSync(0).toString().trim().split("\n");
let [n, q] = input[0].split(" ").map(Number);
let arr = input[1].split(" ").map(Number);
let pt = 0;
for(let i = 2; i < q + 2; ++i) {
    let cmd = input[i].split(" ").map(Number);
    if(cmd[0] === 1) {
        arr[(cmd[1] - 1 + pt) % n] += cmd[2];
    } else if (cmd[0] === 2) {
        pt = (pt + (n - cmd[1])) % n;
    } else {
        pt = (pt + cmd[1]) % n;
    }
}
console.log([...arr.slice(pt), ...arr.slice(0, pt)].join(" "));
