let ans = 0;
require('fs').readFileSync(0).toString().trim().split(" ").forEach(e =>{
    ans += +e.split("").reverse().join("");
})
console.log(+ans.toString().split("").reverse().join(""))