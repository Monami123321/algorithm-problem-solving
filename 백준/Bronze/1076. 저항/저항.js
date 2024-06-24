let input = require('fs').readFileSync(0).toString().trim().split("\n");
let arr = new Array(10).fill(0).map((e,index)=> [index, Math.pow(10, index)]);
const map = new Map();
map.set("black", arr[0]);
map.set("brown", arr[1]);
map.set("red", arr[2]);
map.set("orange", arr[3]);
map.set("yellow", arr[4]);
map.set("green", arr[5]);
map.set("blue", arr[6]);
map.set("violet", arr[7]);
map.set("grey", arr[8]);
map.set("white", arr[9]);
console.log((map.get(input[0])[0] * 10 + map.get(input[1])[0]) * map.get(input[2])[1]);
