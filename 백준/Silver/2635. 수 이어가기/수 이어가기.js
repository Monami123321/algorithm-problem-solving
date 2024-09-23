let start = +require('fs').readFileSync(0);
let ansCnt = 0;
let ans;

for(let i = 0; i <= start; ++i) {
    let arr = [start, i];
    dfs(arr, 2);
}
console.log(`${ansCnt}\n${ans.join(" ")}`);

function dfs(arr, depth) {
    let now = arr[depth - 2] - arr[depth - 1];
    if(now >= 0) {
        arr.push(now);
        dfs(arr, depth + 1);
    } else {
        if(ansCnt < arr.length) {
            ans = arr;
            ansCnt = arr.length;
        }
    }
}