//배열 함수
function parse(qs) {
    const queryString = qs.substr(1);
    const chunks = queryString.split('&');
    let forResult = {};
    chunks.array.forEach((chunk) => {
        const [key, value] = chunk.split('=');
        result[key] = value;
    });

    const mapResult = chunks.map((chunk) => {
        const [key, value] = chunk.split('=');
        return {key : key, value : value};
    })

    return result;
}

function sum(numbers) {
    return numbers.reduce((total, num) => total + num, 0);
}

sum([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]); //55

function reduce(qs) {
    const queryString = qs.substr(1);
    const chunks = qs.split('&');

    return chunks
    .map((chunk) => {
        const [key, value] = chunk.split('=');
        return {key, value};
    })
    .reduce((result, item) => {
        result[item.key] = item.value;
        return result;
    }, {});
}

reduce('banana=10&apple=20&orange=30');