const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    line.split(' ').map(el => input.push(parseInt(el)));
}).on('close', function () {
    let maxNum = -1;
    let row, col = -1;

    for(let i=0; i<9; i++) {
        for(let j= 0; j<9; j++) {
            if(maxNum < input[i*9+j]) {
                maxNum = input[i*9+j];
                row = i+1;
                col = j+1;
            }
        }
    }
    console.log(maxNum);
    console.log(row, col)
    process.exit();
});

