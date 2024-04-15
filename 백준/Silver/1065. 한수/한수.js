let n = +require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
if(n<100) {
    console.log(n)
    return;
}

let arr = new Array(n+1).fill(0)
for(let i = 1; i<100; ++i) {
    arr[i] = i;
}
outer:for(let i = 100; i<=n; ++i) {
    let tmp = i.toString()
    let target = parseInt(tmp.charAt(0)) - parseInt(tmp.charAt(1))
    for(let j = 1; j<tmp.length-1; j++) {
        if(parseInt(tmp.charAt(j)) - parseInt(tmp.charAt(j+1)) !== target) {
            arr[i] = arr[i-1]
            continue outer;
        }
    }
    arr[i] = arr[i-1]+1
}
console.log(arr[n])