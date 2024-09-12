console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1)
    .map(e=> {
    let [a, b, c] = e.split(" ").map(Number);
    if(a > b-c) {
        return "do not advertise";
    } else if(a === b - c) {
        return "does not matter";
    } else {
        return "advertise";
    }
}).join("\n"))

