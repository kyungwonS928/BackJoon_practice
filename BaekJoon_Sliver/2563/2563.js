const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

readline.on('line', function (line) {
    line.split('\n').map(el => input.push((el)));
}).on('close', function () {
    const n = parseInt(input[0]);
    let ans = 0;
    let arr = Array.from(Array(100), () => Array(100).fill(0))
    for (t = 1; t <= n; t++) {
  	    const tmp = input[t].split(" ").map(i => parseInt(i));
	    let r = tmp[0];
	    let c = tmp[1];
	    for (i = r; i < r+10; i++) {
		    for (j = c; j < c+10; j++) {
			    if (++arr[i][j] == 1)
				ans++;
		    }
	    }
    } 
    console.log(ans);
    process.exit();
});

