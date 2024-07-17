const arr = "WelcomeToSMUPC".split("");
console.log(arr[(+require('fs').readFileSync(0) -1) % 14]);