function sumExcept(array, indexSkip, nSkip) {
    sum = 0;
    if (indexSkip < 0 || !Number.isInteger(indexSkip)) {
        indexSkip = 0;
    }
    if (nSkip < 0 || !Number.isInteger(nSkip)) {
        nSkip = 0;
    }
    for (let index = 0; index < indexSkip && index < array.length; index++) {
        if (Number.isInteger(array[index])) {
            sum += array[index];
        }
    }
    for (let index = indexSkip + nSkip; index < array.length; index++) {
        if (Number.isInteger(array[index])) {
            sum += array[index];
        }
    }
    return sum;
}

module.exports = sumExcept
