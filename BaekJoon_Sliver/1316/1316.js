const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    line.split(' ').map(el => input.push(line));
}).on('close', function () {
    let cnt = 0;
    for(let i = 1; i<input.length; i++ ){
        const word = input[i]
        const used = [];
        let flag = true;
        for(let j = 0; j<word.length; j++) {
            const letter = word[j];

            if(!used.includes(letter)) {
                used.push(letter);
            } else if (letter !== word[j-1]) {
                flag = false;
            }
        }
        if(flag) cnt++;
    }

    console.log(cnt);
    process.exit();
});


