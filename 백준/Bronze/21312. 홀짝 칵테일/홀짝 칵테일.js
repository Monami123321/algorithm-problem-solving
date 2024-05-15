let arr = require('fs').readFileSync(0).toString().split(" ").map(Number);
console.log([...arr, arr[0] * arr[1], arr[0] * arr[2], arr[1] * arr[2], arr[0] * arr[1] * arr[2]].sort((a,b)=> {
    if((a & 1) === 0  && (b & 1) === 0) {
        return b-a;
    } else if ((a & 1) == 0 ) {
        return 1;
    } else if ((b & 1) == 0) {
        return -1;
    } else {
        return b-a;
    }
})[0]);