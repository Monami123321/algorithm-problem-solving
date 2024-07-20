const set = new Set(["Never gonna give you up",
"Never gonna let you down",
"Never gonna run around and desert you",
"Never gonna make you cry",
"Never gonna say goodbye",
"Never gonna tell a lie and hurt you",
"Never gonna stop"]);
console.log(require('fs').readFileSync(0).toString().trim().split("\n").slice(1)
.filter(e => !set.has(e)).length === 0 ? "No" : "Yes");