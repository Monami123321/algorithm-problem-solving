let n = +require('fs').readFileSync(0);
n = (n * (n + 1)) >> 1;
console.log(`${n}\n${n * n}\n${n * n}`);
