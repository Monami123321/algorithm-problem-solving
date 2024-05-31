console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1).map(e => {
    let arr = e.split(" ").map(BigInt);
    let org = arr[0] * arr[1];
    let less = org - org % (arr[2] * arr[2]);
    if(less === 0n) {
        return (arr[2] * arr[2]).toString();
    }
    let bigger = less + arr[2] * arr[2];
    return (org - less > bigger - org ? bigger : less).toString();
}).join("\n"));
