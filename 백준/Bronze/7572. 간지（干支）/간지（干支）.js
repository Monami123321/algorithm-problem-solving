let arr = ['A','B','C','D','E','F','G','H','I','J','K','L'];
let n = +require('fs').readFileSync(0);
console.log(arr[((n % 12) + 8) % 12] + ((n % 10) + 6) % 10);
