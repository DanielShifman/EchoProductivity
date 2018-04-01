const lib = require('lib')({token: 'xB_7UfUOpZ-TlROsv-NZLjgdSRRPqT8xm6xpOIv_Q1OlF78zu3a3ZhWcAQ1kcCVx'});

/**
* @param {string} name Intent Name (Automatically Populated by Handler)
* @returns {any}
*/
module.exports = (name = '', callback) => {

	return callback(null, 'This will send message when called');

};

recipient = lib.utils.storage.get('rec', (err, value) => {});
message = lib.utils.storage.get('mes', (err, value) => {});

if (typeof recipient === 'number') {
	lib.utils.sms({
		to: recipient,
		body: message
	}, (err, result) => {
	});
}