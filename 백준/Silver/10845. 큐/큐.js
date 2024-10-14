let q = [];
let ans = "";
require('fs').readFileSync(0).toString().trim().split("\n").slice(1).forEach(e => {
    let arr = e.split(" ");
    switch(arr[0]) {
        case "push":
            q.push(+arr[1]);
            break;
        case "pop":
            ans += `${q.length === 0 ? -1 : q.shift()}\n`;
            break;
        case "size":
            ans += `${q.length}\n`;
            break;
        case "empty":
            ans += `${q.length === 0 ? 1 : 0}\n`;
            break;
        case "front":
            ans += `${q.length === 0 ? -1 : q[0]}\n`;
            break;    
        case "back":
            ans += `${q.length === 0 ? -1 : q[q.length - 1]}\n`;
            break;
    }
});
console.log(ans);