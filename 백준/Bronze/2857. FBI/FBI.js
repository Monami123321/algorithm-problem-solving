let ans = "";
require('fs').readFileSync(0).toString().trim().split("\n").forEach((e,i) => {
    if(e.includes("FBI")) {
        ans += `${i + 1} `;
    }
});
console.log(ans === "" ? "HE GOT AWAY!" : ans);