console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1).map(e => {
   return e.length >=6 && e.length <= 9 ? "yes" : "no";
}).join("\n"));