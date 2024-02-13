// Для чтения входных данных в Node.js необходимо использовать
// модуль readline, который работает с потоком ввода-вывода
// (stdin/stdout) и позволяет читать строки.
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Данные во входном потоке могут состоять из нескольких строк.
// Чтобы прочитать их, можно использовать метод rl.on(),
// который вызывается каждый раз при появлении новой строки
// в потоке ввода.
// Чтобы вывести результат в поток вывода (stdout),
// можно использовать метод console.log().
// Пример:
// console.log('Результат:', result);

// Пример решения задачи "Вычислите сумму A+B":
rl.on('line', line => {
    // let n = 1;
    let n = Number(line);

let arrN = Array(n + 1);
let arrIndex = Array(n + 1);
arrN[1] = 0;
arrIndex[1] = -1;
for (let index = 2; index < n + 1; index++) {
    let step1 = arrN[index - 1] + 1;
    var step2 = Infinity;
    var step3 = Infinity;
    if (index%2 == 0) {
        step2 = arrN[index/2] + 1;
    }
    if (index%3 == 0) {
        step3 = arrN[index/3] + 1;
    }
    if (step1 < step2) {
        if (step1 < step3) {
            arrN[index] = step1;
            arrIndex[index] = index - 1;
        }
        else {
            arrN[index] = step3;
            arrIndex[index] = index/3;
        }
    } else
        if (step3 < step2) {
            arrN[index] = step3;
            arrIndex[index] = index/3;
        }
        else {
            arrN[index] = step2;
            arrIndex[index] = index/2;
        }

}
var strElem = String(n);
var tempIndex = arrIndex[n];
while (tempIndex != -1) {
    strElem = tempIndex + " " + strElem;
    tempIndex = arrIndex[tempIndex];
}

 console.log(arrN[n]);
 console.log(strElem);
 rl.close();
});
