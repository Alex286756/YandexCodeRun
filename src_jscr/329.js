module.exports = function(fullCode) {
    var result = "";
    var index = 0;
    while (index < fullCode.length) {
        var temp = "";
        if (fullCode[index+0] == "R") {
            temp = fullCode[index+1] + fullCode[index+3] + fullCode[index+5] + fullCode[index+7] + fullCode[index+9];
            index += 12;
        } else
        if (fullCode[index+0] == "T") {
            temp = fullCode[index+5] + fullCode[index+4] + fullCode[index+3] + fullCode[index+2] + fullCode[index+1];
            index += 7;
        } else
        if (fullCode[index+0] == " ") {
            temp = " ";
            index += 2;
        } else {
            temp = fullCode[index+0] + fullCode[index+1] + fullCode[index+2] + fullCode[index+3] + fullCode[index+4];
            index += 6;
        }

        switch (temp) {
            case ".----":
                result += "1";
                break;
            case "..---":
                result += "2";
                break;
            case "...--":
                result += "3";
                break;
            case "....-":
                result += "4";
                break;
            case ".....":
                result += "5";
                break;
            case "-....":
                result += "6";
                break;
            case "--...":
                result += "7";
                break;
            case "---..":
                result += "8";
                break;
            case "----.":
                result += "9";
                break;
            case "-----":
                result += "0";
                break;
            case " ":
                result += " ";
            default:
                break;
        }
    };

    return result;
};
