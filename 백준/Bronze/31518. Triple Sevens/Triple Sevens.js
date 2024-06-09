console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1).filter(e => {
    return e.split(" ").includes("7");
}).length === 3 ? "777" : "0");