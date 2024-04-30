let money = [500, 300, 200, 50, 30, 10]
let arrA = []
let ref = 0;
let cnt = 0;
for(let i = 0; i<6; i++) {
    cnt = ++ref;
    while(cnt-- > 0) {
        arrA.push(money[i]);
    }
}
let arrB = []
ref = 1;
for(let i = 0; i < 5; i++) {
    ref = 1 << i;
    cnt = ref;
    while(cnt-- > 0) {
        arrB.push(512 >> i);
    }
}

const input = require('fs').readFileSync(0).toString().trim().split("\n");
let ans = ""
let tc = +input.shift()
while(tc-- > 0) {
    let [a, b] = input.shift().split(" ").map(e => +e -1);
    a = (a < 0 || a > 20) ? 0 : arrA[a];
    b = (b < 0 || b > 30) ? 0 : arrB[b];
    ans += ((a + b) * 10000) + "\n";
}
console.log(ans);