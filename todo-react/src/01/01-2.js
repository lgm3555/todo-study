//ES6 배열 전개 연산자
var array1 = ['one', 'two', 'other', 'check', 'total'];
var array2 = ['three', 'four'];
var combined = [...array1, ...array2];
console.log(combined)
// 결과: ['one', 'two', 'other', 'check', 'total', 'three', 'four']
const [first, second, three='empty', ...others] = array1
console.log(three)

function func(...args) {
    var [first, ...others] = args;
}
function func(first, ...others) {
    var firstInES6 = first;
    var othersInES6 = others;
}