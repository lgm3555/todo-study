//디바운스
function debounce(func, delay) {
    let inDebounce;
    return function(...args) {
        if (inDebounce) {
            clearTimeout(inDebounce);
        }
        inDebounce = setTimeout(() => func(...args), delay);
    }
}

const run = debounce(val => console.log(val), 1000);
run('a');
run('b');
run(2);