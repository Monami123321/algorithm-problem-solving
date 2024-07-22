console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1)
    .map(e=> {
        const arr = e.split("-");
        const left = arr[0].split("").map(el => el.charCodeAt(0) - 65);
        const val = Math.abs(left[0] * 26 * 26 + left[1] * 26 + left[2] - parseInt(arr[1]));
        return val <= 100 ? "nice" : "not nice";
    }).join("\n"));
