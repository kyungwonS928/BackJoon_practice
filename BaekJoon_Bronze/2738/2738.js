const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    line.split(' ').map(el => input.push(parseInt(el)));
}).on('close', function () {
    let size = input[0] * input[1];
    let matrix1 = input.slice(2, 2+size);
    let matrix2 = input.slice(2+size);


    for(let i = 0; i<input[0]; i++) {
        let result = "";
        for(let j = 0; j<input[1]; j++){
            result += (matrix1[i*input[1]+j] + matrix2[i*input[1]+j]);
            result +=" ";
            
        }
        console.log(result);
    }
    

    process.exit();
});


