function createCountdown(n) {

    var count;

    if (n <= 0 || !Number.isInteger(n)) {
        count = 0;
    } else {
        count = n;
    }

    return function minusOne() {
        var res = 0;
        if (count != 0) {
            res = count;
            count--;
        }
        return res;
    }
  }

  module.exports = createCountdown
