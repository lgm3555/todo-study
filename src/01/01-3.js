//ES6 객체 전개 연산자
var objectOne = {
    one: 1,
    two: 2,
    other: 0
};

var objectTwo = {
    three: 3,
    four: 4,
    other: -1
};

var combined = {
    ...objectOne,
    ...objectTwo
}

var {other, ...others} = combined;
console.log("other = " + other);