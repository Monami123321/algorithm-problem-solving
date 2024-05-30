let ans = "";
require('fs').readFileSync(0).toString().trim().split("\n").slice(1).forEach(e => {
   let arr = e.split(" ").map(Number);
   ans += getGrade(arr[0], arr[1]) + "\n";
});
console.log(ans);
    
function getGrade(h, w) {
    if(h < 140.1) {
        return 6;
    }
    if(h < 146) {
        return 5;
    }
    if(h < 159) {
        return 4
    }
    if(h >= 204) {
        return 4
    }
    let bmi = w / ( (h / 100) * (h / 100) );
    if(h < 161) {
        if(bmi < 16 || bmi >= 35) {
            return 4;
        } else {
            return 3;
        }
    }
    if(bmi < 16 || bmi >= 35) {
        return 4;
    } else if (bmi < 18.5 || bmi >= 30) {
        return 3;
    } else if (bmi < 20 || bmi >=25) {
        return 2;
    } else {
        return 1;
    }
}