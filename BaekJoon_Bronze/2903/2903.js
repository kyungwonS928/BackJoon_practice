const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    line.split(' ').map(el => input.push(parseInt(el)));
}).on('close', function () {
    let dots = 4;
    let line = 4;
    for(let i = 0; i<input[0]; i++) {
        
        dots= dots + 4 ** i + line;
        line = 4**(i+1) + line *2
    }   
    console.log(dots);
});

