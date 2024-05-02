const arr = new Array(26).fill(-1);
[...require('fs').readFileSync(0).toString().trim()].forEach( (e,index) => {
    let target = e.charCodeAt(0) - 97;
    if(arr[target] == -1) {
        arr[target] = index;
    }
});
console.log(arr.join(" "));