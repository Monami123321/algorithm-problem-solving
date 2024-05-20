const input = require('fs').readFileSync(0).toString().trim();
if(input.includes("D2") || input.includes("d2")) {
    console.log("D2");
} else {
    console.log("unrated")
}