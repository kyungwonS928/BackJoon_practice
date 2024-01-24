const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    line.split(' ').map(el => input.push(el));
}).on('close', function () {
    let numInput = input[0];
    let numB = parseInt(input[1]);
    let result = 0;

    for(let i = 0; i < numInput.length; i++) {
        let num = 0;

        if(numInput[i] == '0' || numInput[i] == '1' || numInput[i] == '2'||numInput[i] == '3'||numInput[i] == '4'||numInput[i] == '5'||numInput[i] == '6'||numInput[i] == '7' ||numInput[i] == '8' ||numInput[i] == '9') {
            num = parseInt(numInput[i]);
        } else {
            num = numInput[i].charCodeAt() - 55;
        }
        
        result += num * (numB ** (numInput.length-i-1));
    }

    console.log(result)
    process.exit();
});

