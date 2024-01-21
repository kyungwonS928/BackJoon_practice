const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    input.push(line);
    readline.close()
}).on('close', function () {
    console.log(input[0].replace(/c=|c-|dz=|d-|lj|nj|s=|z=|./g,'a').length);
    process.exit();
});


