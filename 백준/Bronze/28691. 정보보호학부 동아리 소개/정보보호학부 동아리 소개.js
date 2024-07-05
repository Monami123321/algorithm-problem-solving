let ans = "";
switch (require('fs').readFileSync(0).toString().trim()) {
    case "M":
        ans = "MatKor";
        break;
    case "W":
        ans = "WiCys";
        break;
    case "C":
        ans = "CyKor";
        break;
    case "A":
        ans = "AlKor";
        break;
    case "$":
        ans = "$clear";
        break;
    default:
        break;
}
console.log(ans);