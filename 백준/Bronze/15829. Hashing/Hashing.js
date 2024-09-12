console.log(require('fs').readFileSync(0).toString().trim()
    .split("\n")[1].split("")
    .reduce((total, prev, index)=> total + (prev.charCodeAt(0) - 96) * Math.pow(31, index), 0) % 1234567891);