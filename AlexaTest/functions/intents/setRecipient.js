const lib = require('lib')({token: 'xB_7UfUOpZ-TlROsv-NZLjgdSRRPqT8xm6xpOIv_Q1OlF78zu3a3ZhWcAQ1kcCVx'});

recipient = '';
lib.utils.storage.set('rec', recipient, (err, value) => {});


/**
* @param {string} name Intent Name (Automatically Populated by Handler)
* @returns {any}
*/
module.exports = (name = ' ', callback) => {

	return callback(null, 'This will respond to set recipient command');

};