console.log(require('fs').readFileSync(0).toString().trim()
    .split("\n")[1].split("")
    .reduce((total, now, index)=> {
    let r = 1;
    for(let i = 0; i < index; ++i) {
        r *= 31;
        r %= 1234567891;
    }
    return total + ((now.charCodeAt(0) - 96) * r) % 1234567891;
}, 0) % 1234567891);
            