const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    line.split(' ').map(el => input.push(parseInt(el)));
}).on('close', function () { 
    let snailA = input[0];
    let snailB = input[1];
    let treeV = input[2];
    let days = 0;

    days = Math.ceil((treeV-snailB) / (snailA-snailB));


    console.log(days);
});

