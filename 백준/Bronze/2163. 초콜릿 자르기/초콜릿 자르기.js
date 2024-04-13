let [n,m] = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt').toString().trim().split(" ").map(Number)

if(n>m) {
    console.log(cut(n,m))
} else {
    console.log(cut(m,n))
}


function cut(n,m) {
    if(n == 1 && m == 1) {
        return 0;
    }

    if( (n & 1) == 0) {
        if(m > n/2) {
            let half = cut(m,n/2);
            return 2*half + 1
        } else {
            let half = cut(n/2,m);
            return 2*half + 1
        }
    } else {
        if(m > (n+1)/2) {
            return 1 + cut(m,(n+1)/2) + cut(m,Math.floor(n/2))
        } else if ( m > Math.floor(n/2)) {
            return 1 + cut((n+1) / 2,m) + cut(m,Math.floor(n/2))
        } else {
            return 1 + cut((n+1)/2,m) + cut(Math.floor(n/2),m)
        }
    }
}