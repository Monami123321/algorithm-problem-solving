let dic = {"A+" : 4.5,
           "A0" : 4.0,
           "B+" : 3.5,
           "B0" : 3,
           "C+" : 2.5,
           "C0" : 2,
           "D+" : 1.5,
           "D0" : 1,
           "F" : 0,
          };
let arr = require('fs').readFileSync(0).toString().trim().split("\n").map(e=> e.trim().split(" "))
.filter(e => e[2] !== "P");
let len = arr.reduce((total, now) => total + Number(now[1]), 0);
console.log(arr.reduce((total, now) => total + Number(now[1]) * dic[now[2]], 0) / len);

