function alert(array) {
	console.log(array);
	console.log('----------------------------');
}

function showData(a, b) {
	for (let i = 0; i < arguments.length; i++) {
		console.log('-->' + arguments[i]);
	}
	console.log('----------------------------');
}

showData(1);
showData(1, 2);
showData(1, 2, 3);