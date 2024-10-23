console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1).map(e => e.split(" ")).sort((a, b) => {
    if(a[1] != b[1]) {
        return +b[1] - +a[1];
    }
    return a[0].localeCompare(b[0]);
})[0][0]);