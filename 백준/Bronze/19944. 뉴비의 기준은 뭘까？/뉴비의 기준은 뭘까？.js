let [n, m]= require('fs').readFileSync(0).toString().split(" ").map(Number);
if(m < 3) {
    console.log("NEWBIE!");
} else if (m <= n) {
    console.log("OLDBIE!");
} else {
    console.log("TLE!");
}