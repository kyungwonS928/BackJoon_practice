const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    line.split(' ').map(el => input.push(parseInt(el)));
}).on('close', function () {
    let inputNum = input[0];
    let result = '';
    
    for(let i = 1;i<=inputNum; i++) {
        let coin = input[i];

        result = String(parseInt(coin/25));
        coin = coin % 25;

        result = result + ' ' + String(parseInt(coin/10));
        coin = coin %10;

        result = result + ' ' + String(parseInt(coin/5));
        coin = coin %5;

        result = result + ' ' + String(coin);


        console.log(result);

    }

});

