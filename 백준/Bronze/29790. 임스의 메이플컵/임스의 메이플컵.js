let [n, u, l] = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
let ans = "";
if(n >= 1000) {
    if(u >= 8000 || l >= 260) {
        ans = "Very Good";
    } else {
        ans = "Good";
    }
} else {
    ans = "Bad";
}
console.log(ans);
      