let ans = "";
(+require('fs').readFileSync(0).toString().trim()).toString(2).split("").forEach((e,index,arr) => {
    if(e === "1") {
        ans = arr.length-1-index + " " + ans;
    }
});
console.log(ans);