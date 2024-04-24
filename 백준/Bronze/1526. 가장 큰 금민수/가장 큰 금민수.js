let n = +require('fs').readFileSync(0)
while(1) {
    if(isPossible(n)) {
        console.log(n);
        return;
    }
    --n;
}

function isPossible(n) {
    let res = true;
    n.toString().split("").forEach(e => {
        if(e == "4" || e == "7") {
            return;
        }
        res = false;
    }) 
    return res;
}