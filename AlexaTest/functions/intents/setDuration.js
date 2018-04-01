const lib = require('lib')({token: 'xB_7UfUOpZ-TlROsv-NZLjgdSRRPqT8xm6xpOIv_Q1OlF78zu3a3ZhWcAQ1kcCVx'});

duration = 12;
lib.utils.storage.set('dur', duration, (err, value) => {});

/**
* @param {string} name Intent Name (Automatically Populated by Handler)
* @returns {any}
*/
module.exports = (name = '', callback) => {

	return callback(null, 'This will respond to set duration command');

};