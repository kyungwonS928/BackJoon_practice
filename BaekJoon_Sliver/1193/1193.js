const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    line.split(' ').map(el => input.push(parseInt(el)));
}).on('close', function () { 
    let count = input[0];
    let line = 1;
    let total = 0;
    let result = '';


    for(line; total + line<count; line++) {
        total += line;
    }


    if(line % 2 == 0) {

        result = String(1+ (count - total -1)) + '/' + String(line- (count-total-1))
    } else {
        
    result = String(line- (count-total-1)) + '/' + String(1+ (count - total -1))
    }


    console.log(result);
});

