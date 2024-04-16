const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");
const [n,m] = input[0].split(" ").map(Number)
let inputIndex = 1;
let arr = new Array(n)
let hm = new Map();
for(let i = 0; i<n; i++) {
    let groupName = input[inputIndex++]
    let groupNum = +input[inputIndex++]
    let group = new Array(groupNum)
    for(let j = 0; j<groupNum;j++) {
        let name = input[inputIndex++]
        hm.set(name,groupName);
        group[j] = name;
    }
    hm.set(groupName,group)
}
let ans = ""
for(let i =0; i<m; i++) {
    let tmp = hm.get(input[inputIndex++])
    let cmd = +input[inputIndex++]
    if(cmd == 0) {
        tmp.sort().forEach(e=> {
            ans +=e + "\n"
        })
    } else {
        ans += tmp + "\n"
    }
}
console.log(ans)
