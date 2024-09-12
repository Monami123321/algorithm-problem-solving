let n = +require('fs').readFileSync(0);
let ans = "";
let cnt = 0;
move(n, 1, 2, 3);
console.log(`${cnt}\n${ans}`);





function move(n, start, tmp, end) {
    if(n == 1) {
        ++cnt;
        ans += `${start} ${end}\n`;
        return;
    }
    move(n - 1, start, end, tmp);
    ans += `${start} ${end}\n`;
    ++cnt;
    move(n - 1, tmp, start, end);
}