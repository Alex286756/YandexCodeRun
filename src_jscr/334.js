/** @returns string */
module.exports = function(inputString) {
    var result = "0";
    let match = inputString.toLowerCase().match(/\sta'(So|Ko|Ta|Qa|Goo)\s(\d+)/i);
    if (match != null) {
        result = match[1] + " " + match[2];
    }

    return result;
}
