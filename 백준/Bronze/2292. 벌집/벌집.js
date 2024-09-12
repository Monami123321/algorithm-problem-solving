let n = +require('fs').readFileSync(0);
let now = 1;
let i = 1;
while(n > now) {
    now += 6 * i++;
}
console.log(i);