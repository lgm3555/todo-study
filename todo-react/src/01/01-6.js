//ES 화살표 함수 사용 방법
var add = (first, second) => {
    return first + second;
};

var add = (first, second) => first + second;
var addAndMultiple = (first, second) => ({
    add : first + second,
    multiply : first * second
});