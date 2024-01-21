const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    line.split('\n').map(el => input.push(line));
}).on('close', function () {

    let totalScore = 0;
    let totalLecture = 0;

    for(let i = 0; i<input.length; i++) {

        let score = input[i].split(' ')[2];
        let lecture = parseFloat(input[i].split(' ')[1]);
        
        switch(score) {
            case "A+": {
                
                totalLecture += lecture;
                totalScore += 4.5 * lecture;
                break;
            }
            case "A0": {
                
                totalLecture += lecture;
                totalScore += 4.0 * lecture;
                break;

            }
            case "B+": {
                
                totalLecture += lecture;
                totalScore += 3.5 * lecture;
                break;

            }
            case "B0": {
                
                totalLecture += lecture;
                totalScore += 3.0 * lecture;
                break;

            }
            case "C+": {
                
                totalLecture += lecture;
                totalScore += 2.5 * lecture;
                break;

            }
            case "C0": {
                
                totalLecture += lecture;
                totalScore += 2.0 * lecture;
                break;

            }
            case "D+": {
                
                totalLecture += lecture;
                totalScore += 1.5 * lecture;
                break;

            }
            case "D0": {
                
                totalLecture += lecture;
                totalScore += 1.0 * lecture;
                break;

            }
            case "F": {
                
                totalLecture += lecture;
                totalScore += 0.0 * lecture;
                break;

            }
            case "P": {
                break;

            }
            default:

        }
        
    }
    console.log(totalScore/totalLecture);
    process.exit();
});


