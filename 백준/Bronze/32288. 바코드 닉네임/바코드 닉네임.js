console.log(require('fs').readFileSync(0).toString().trim().split("\n")[1].split("").map(e => {
    if(e === 'l') {
        return 'L';
    } 
    return 'i';
}).join(""));