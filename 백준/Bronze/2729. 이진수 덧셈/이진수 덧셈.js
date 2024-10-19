console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1)
            .map(e=> e.split(" ").map(el => BigInt("0b" + el))
                 .reduce((total, now) => total + now)
                 .toString(2)).join("\n"));