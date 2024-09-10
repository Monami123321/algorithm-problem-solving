console.log(require('fs')
    .readFileSync(0)
    .toString()
    .trim()
    .split("\n")
    .map(e =>  e.split(" ").map(Number).reduce( (prev, total) => (prev / total).toFixed(2) ))
    .join("\n"));