const set = new Set(require('fs').readFileSync(0).toString().trim().split("\n").map(e => e[0]));
if(set.has("l") && set.has("p") && set.has("k")) {
    console.log("GLOBAL");
} else {
    console.log("PONIX");
}