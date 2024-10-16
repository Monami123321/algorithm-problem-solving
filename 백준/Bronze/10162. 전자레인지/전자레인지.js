let n = +require('fs').readFileSync(0);
let arr = [0, 0, 0];

if(n % 10 !== 0) {
    console.log(-1);
} else {
    arr[0] += Math.floor(n / 300);
    n %= 300;
    arr[1] += Math.floor(n / 60);
    n %= 60;
    arr[2] += Math.floor(n / 10);
    console.log(arr.join(" "));    
}
