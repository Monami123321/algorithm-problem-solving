let n = +require('fs').readFileSync(0);
console.log(`${(BigInt(n) * BigInt(n) * BigInt(n)).toString()}\n3`);