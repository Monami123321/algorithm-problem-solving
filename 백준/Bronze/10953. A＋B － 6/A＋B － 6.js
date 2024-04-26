let ans = ""
const arr = require('fs').readFileSync(process.platform === 'linux' ? 0 : './input.txt').toString().trim().split("\n")
arr.shift()
arr.forEach(e => {
    ans += e.split(",").reduce((prev, now) => {
        return prev + +now
    },0) + "\n"
})
console.log(ans)