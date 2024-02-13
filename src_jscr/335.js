module.exports = (password) => {
    var count1 = 0;
    var count7 = false;
    if (password.length == 0) {
        return false;
    }
    for (let index = 0; index < password.length; index++) {
        switch (password[index]) {
            case "1":
                count1++;
                break;
            case "7":
                if (count7) {
                   if (count1%2 == 1) {
                     return false;
                   }
                } else {
                    if (count1%4 != 0) {
                        return false;
                    }
                }
                count7 = true;
                count1 = 0;
                break;
            default:
                return false;
        }
    }
    if (count7) {
        if (count1%2 == 1) {
          return false;
        }
     } else
         if (count1%4 != 0) {
             return false;
         }

    return true;
}
