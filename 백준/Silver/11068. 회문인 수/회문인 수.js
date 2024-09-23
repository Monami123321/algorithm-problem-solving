console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1).map(e => {
    e = +e;
    for(let i = 2; i <= 64; ++i) {
        let arr = [];
        let now = e;
        while(now >= i) {
            arr.push(now % i);
            now = Math.floor(now / i);
        }
        arr.push(now);
        if(isPalindrome(arr)) {
            return 1;
        }
    }
    return 0;
}).join("\n"));

function isPalindrome(arr) {
    let index = 0;
    let limit = arr.length - 1 >> 1;
    while(index <= limit) {
        if(arr[index] !== arr[arr.length - 1 - index]) {
            return false;
        }
        index++;
    }
    return true;
}