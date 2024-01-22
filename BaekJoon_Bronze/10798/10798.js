const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    line.split('\n').map(el => input.push((el.replace(/\s/g, ""))));
}).on('close', function () {
    let result = "";


    for(let i=0; i<15; i++) {
        for(let j= 0; j<input.length; j++) {
            
            if(input[j][i]) result += input[j][i];
        }
    }
    console.log(result);
    process.exit();
});

