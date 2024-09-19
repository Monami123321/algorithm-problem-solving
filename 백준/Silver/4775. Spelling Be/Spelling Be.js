let input = require('fs').readFileSync(0).toString().trim().split("\n");
let n = +input.shift();
const set = new Set(input.slice(0, n + 1).map(e => e.trim()));
input = input.slice(n);

let ans = [];
n = +input.shift();

while(n-- > 0) {
    let flag = true;
    let mail = {
        "isCorrect" : true,
        "list" : []
    };
    while(true) {
        let now = input.shift().trim();
        if(now === "-1") {
            break;
        }
        if(!set.has(now)) {
            flag = false;
            mail.list.push(now);
        }
    }
    mail.isCorrect = flag;
    ans.push(mail);
}
console.log(ans.map((e, i) => {
    if(e.isCorrect) {
        return `Email ${i + 1} is spelled correctly.`;
    }
    return `Email ${i + 1} is not spelled correctly.\n${e.list.join("\n")}`
}).join("\n") + "\nEnd of Output");

                    
                    