console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1).map(e=> e.split(" ").map(Number))
.filter(e=> {
    let cnt = e[0] === -1 ? 0 : 1;
    let prev = e[0];
    for(let i = 1; i < 3; ++i) {
        if(e[i] === -1) {
            continue;
        }
        if(e[i] < prev) {
            return false;
        }
        
        if(cnt < i) {
            return false;
        }
        ++cnt;
        prev = e[i];
    }
    if(cnt === 0) {
        return false;
    }
    return true;
}).length);

