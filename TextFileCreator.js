textFile = null,
	const lib = require('lib')({token: 'xB_7UfUOpZ-TlROsv-				NZLjgdSRRPqT8xm6xpOIv_Q1OlF78zu3a3ZhWcAQ1kcCVx'});
    
	duration = lib.utils.storage.get('dur', (err, value) => {});
	recipient = lib.utils.storage.get('rec', (err, value) => {});
	message = lib.utils.storage.get('mes', (err, value) => {});
	text = recipient + message + duration;
	console.log(text);

	makeTextFile = function (text) {
    	data = new Blob([text], {type: 'text/plain'});

    	if (textFile !== null) {
   	   window.URL.revokeObjectURL(textFile);
   	 }

    	textFile = window.URL.createObjectURL(data);

    	return textFile;
  };