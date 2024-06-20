let n = +require('fs').readFileSync(0);
console.log("V".repeat(Math.floor(n / 5)) + "I".repeat((n % 5)));