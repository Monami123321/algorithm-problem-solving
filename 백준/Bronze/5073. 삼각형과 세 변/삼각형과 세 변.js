let ans = "";
require('fs').readFileSync(0).toString().trim().split("\n").map(e => e.split(" ").map(Number).sort((a, b) => +a - +b))
    .forEach(el => {
    if(el[0] === 0) {
        return;
    }
    let [a,b,c] = el;
    if(a + b <= c) {
    ans += "Invalid\n";
} else if (a === b && b === c) {
    ans += "Equilateral\n";
} else if (a === b || b === c || c == a) {
    ans += "Isosceles\n";
} else {
    ans += "Scalene\n";
}  
});
console.log(ans);