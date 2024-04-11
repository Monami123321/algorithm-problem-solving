console.log(parseInt(require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt').toString().trim(),16))
