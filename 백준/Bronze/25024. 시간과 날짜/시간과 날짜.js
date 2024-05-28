let ans = "";
let month = [0,31,29,31,30,31,30,31,31,30,31,30,31];
require('fs').readFileSync(0).toString().trim().split("\n").slice(1)
.forEach(e => {
    let arr = e.split(" ").map(Number);
    if(isPossibleTime(arr[0], arr[1])) {
        ans += "Yes ";
    } else {
        ans += "No ";
    }
    if(isPossibleDate(arr[0], arr[1])) {
        ans +="Yes\n";
    } else {
        ans +="No\n";
    }
});
console.log(ans);

function isPossibleTime(h, m) {
    return h < 24 && m < 60;
}
function isPossibleDate(m, d) {
    return 0 < m && m < 13 && 0 < d && d <= month[m]
}