const input = require('fs').readFileSync(0).toString().trim().split("\n");
let n = +input.shift();
class Node {
    constructor(age, name, index) {
        this.age = age;
        this.name = name;
        this.index = index;
    }
}
let arr = new Array(n);
while(n-- > 0) {
    let tmp = input.shift().split(" ");
    arr[n] = new Node(+tmp[0], tmp[1], (arr.length - 1) - n);
}
let ans = "";
arr.sort((a,b) => {
    if(a.age !== b.age) {
        return a.age - b.age;
    }
    return a.index - b.index;
}).forEach(e => {
    ans += e.age + " " + e.name + "\n";
});
console.log(ans);
