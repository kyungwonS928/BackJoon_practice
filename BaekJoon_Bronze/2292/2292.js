const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    line.split(' ').map(el => input.push(parseInt(el)));
}).on('close', function () { 
    let count = 1;
    let rooms = 1;
    for(let i = 1; count < input[0]; i++) {
        count += i*6;
        rooms++;
    }

    console.log(rooms);
});

