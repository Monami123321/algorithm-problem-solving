const input = require('fs').readFileSync(0).toString().trim().split("\n").map(Number);
let ans = "";
let index = 1;
while(input[0]-- > 0) {
    let n = input[index++];
    let arr = input.slice(index, index + n);
    ans += find(arr) + "\n";
    index += n;
}
console.log(ans);

function find(arr) {
    let set = new Set();
    let n = 1;
    outer:while(true) {
        for(let e of arr) {
            let mod = e % n;
            if(set.has(mod)) {
                set.clear();
                n++;
                continue outer;
            }
            set.add(mod);
        }
        break;
    }
    return n;
}