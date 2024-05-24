const arr = require('fs').readFileSync(0).toString().split("\n").map(Number);
let index = 0;
let tc = arr[index++];
let ans = "";
let ref = [25, 10, 5, 1];
while(tc-- > 0) {
    let now = arr[index++];
    ref.forEach(e => {
        ans += Math.floor(now / e) + " ";
        now %= e;
    });
    ans +="\n";
}
console.log(ans);