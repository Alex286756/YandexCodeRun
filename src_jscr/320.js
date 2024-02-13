/**
 *
 * @typedef Replace
 *
 * @property {string} from
 * @property {string} to
 */

/**
 *
 * @param {string} message
 * @param {Replace[]} replaces
 * @returns {string}
 */

function decode(message, replaces) {
    var newMessage = "";
    var indexLeft = 0;
    var indexRight = 1;
    let len = message.length;
    while (indexLeft < len) {
        var sub = message.substring(indexLeft, indexRight);
        var temp = sub;
        var ruleTemp = null;
        var ruleExact = null;
        for (let index = 0; index < replaces.length; index++) {
            const element = replaces[index];
            if (element.from.startsWith(temp)) {
                ruleTemp = element;
            }
            if (element.from == temp) {
                ruleExact = element;
            }
        }


        while (indexRight <= len && ruleTemp != null) {
            indexRight++;
            temp = message.substring(indexLeft, indexRight);
            ruleTemp = null;
            for (let index = 0; index < replaces.length; index++) {
                const element = replaces[index];
                if (element.from.startsWith(temp)) {
                    ruleTemp = element;
                }
                if (element.from == temp) {
                    ruleExact = element;
                    sub = temp;
                }
            }
        }

        if (ruleExact != null) {
            newMessage += ruleExact.to;
            indexLeft += sub.length;
            indexRight == indexLeft + 1;
        } else {
            newMessage += message[indexLeft];
            indexLeft++;
            indexRight = indexLeft + 1;
        }
    }


    return newMessage;
}

module.exports = { decode };
