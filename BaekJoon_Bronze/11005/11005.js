const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    line.split(' ').map(el => input.push(parseInt(el)));
}).on('close', function () {
    let binary = input [1];
    let result ='';
    
    let quotient = input[0], remainder = 0;
    
    while(quotient >= binary) {
        
        

        remainder = String(quotient % binary);

        if(remainder > 9) {
            remainder = String.fromCharCode(parseInt(remainder) + 55);
        }
        
        result = remainder + result;      
        quotient = parseInt(quotient / binary);
    }
    if (quotient > 9) {
        result = String.fromCharCode(quotient + 55) + result;
    } else {
        result = quotient + result;
    }
    

    console.log(result);
});

